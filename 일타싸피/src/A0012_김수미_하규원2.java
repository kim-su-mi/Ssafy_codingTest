import java.net.*;
import java.io.*;

public class A0012_김수미_하규원2 {
	// 당구공 반지름
    static final float BALL_RADIUS = 5.73f;
    // 쿠션 반사 계수
    static final float CUSHION_RESTITUTION = 0.7f;
    
    // 홀 근처 판정 거리
    static final float HOLE_THRESHOLD = 7.0f;

    public static class Vector2D {
        float x, y;
        
        public Vector2D(float x, float y) {
            this.x = x;
            this.y = y;
        }
        
        public float distance(Vector2D other) {
            float dx = this.x - other.x;
            float dy = this.y - other.y;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }
        
        public Vector2D subtract(Vector2D other) {
            return new Vector2D(this.x - other.x, this.y - other.y);
        }
        
        public float length() {
            return (float) Math.sqrt(x * x + y * y);
        }
        
        public Vector2D normalize() {
            float len = length();
            return new Vector2D(x / len, y / len);
        }
    }

    // 최적의 홀 찾기
    private static int findBestHole(float ballX, float ballY) {
        int bestHole = 0;
        float minDist = Float.MAX_VALUE;
        
        for (int i = 0; i < HOLES.length; i++) {
            float dx = HOLES[i][0] - ballX;
            float dy = HOLES[i][1] - ballY;
            float dist = (float) Math.sqrt(dx * dx + dy * dy);
            
            if (dist < minDist) {
                minDist = dist;
                bestHole = i;
            }
        }
        return bestHole;
    }

    // 충돌 각도 계산
    private static float calculateCollisionAngle(Vector2D whiteBall, Vector2D targetBall, Vector2D hole) {
        // 목적구에서 홀까지의 방향 벡터
        Vector2D ballToHole = new Vector2D(hole.x - targetBall.x, hole.y - targetBall.y);
        // 흰 공이 목적구를 맞춰야 하는 지점 계산
        float hitPointX = targetBall.x - (BALL_RADIUS * 2 * ballToHole.x / ballToHole.length());
        float hitPointY = targetBall.y - (BALL_RADIUS * 2 * ballToHole.y / ballToHole.length());
        
        // 흰 공에서 타격 지점까지의 각도 계산
        float dx = hitPointX - whiteBall.x;
        float dy = hitPointY - whiteBall.y;
        return (float) (Math.atan2(dy, dx) * 180 / Math.PI);
    }

    // 파울 체크
    private static boolean checkFoul(float[][] balls, Vector2D whiteBall, float angle, int targetBallIdx) {
        // 흰 공의 진행 방향 벡터
        float dirX = (float) Math.cos(angle * Math.PI / 180);
        float dirY = (float) Math.sin(angle * Math.PI / 180);
        
        // 모든 공에 대해 충돌 체크
        for (int i = 1; i < balls.length; i++) {
            if (i == targetBallIdx || balls[i][0] == -1) continue;
            
            // 진행 경로상에 다른 공이 있는지 확인
            float dx = balls[i][0] - whiteBall.x;
            float dy = balls[i][1] - whiteBall.y;
            float dist = (float) Math.sqrt(dx * dx + dy * dy);
            
            if (dist < BALL_RADIUS * 2) {
                return true;
            }
        }
        return false;
    }

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "KIMSUMI";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				

				Vector2D whiteBall = new Vector2D(balls[0][0], balls[0][1]);
	            
	            // 타겟 공 결정
	            int targetBallIdx = -1;
	            if (order == 1) {
	                if (balls[1][0] != -1) targetBallIdx = 1;
	                else if (balls[3][0] != -1) targetBallIdx = 3;
	                else if (balls[5][0] != -1) targetBallIdx = 5;
	            } else {
	                if (balls[2][0] != -1) targetBallIdx = 2;
	                else if (balls[4][0] != -1) targetBallIdx = 4;
	                else if (balls[5][0] != -1) targetBallIdx = 5;
	            }

	            if (targetBallIdx != -1) {
	                Vector2D targetBall = new Vector2D(balls[targetBallIdx][0], balls[targetBallIdx][1]);
	                
	                // 최적의 홀 찾기
	                int bestHole = findBestHole(targetBall.x, targetBall.y);
	                Vector2D hole = new Vector2D(HOLES[bestHole][0], HOLES[bestHole][1]);

	                // 충돌 각도 계산
	                angle = calculateCollisionAngle(whiteBall, targetBall, hole);

	                // 파울 체크 및 쿠션 샷 시도
	                if (checkFoul(balls, whiteBall, angle, targetBallIdx)) {
	                    // 쿠션 샷 시도
	                    // 가장 가까운 쿠션을 이용한 샷 계산
	                    angle = (angle + 180) % 360; // 쿠션 반사각 계산 (90도 보정 포함)
	                }

	                // 거리에 따른 파워 조절
	                float distance = whiteBall.distance(targetBall);
	                power = Math.min(100, distance * 1.5f);
	            }

                angle += 90;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
