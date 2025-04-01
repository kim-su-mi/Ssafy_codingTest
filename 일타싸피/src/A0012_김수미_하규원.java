import java.net.*;
import java.io.*;

public class A0012_김수미_하규원 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "김수미,하규원";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "70.12.50.200";

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

	
	// 난이도를 계산하는 메서드 추가
    private static double calculateShotDifficulty(float whiteX, float whiteY, 
                                                float targetX, float targetY) {
        // 흰 공과 목적구 사이의 거리 계산
        double distanceToTarget = Math.sqrt(
            Math.pow(targetX - whiteX, 2) + Math.pow(targetY - whiteY, 2)
        );
        
        // 목적구와 가장 가까운 홀까지의 거리 계산
        double minHoleDistance = Double.MAX_VALUE;
        for(int[] hole : HOLES) {
            double distanceToHole = Math.sqrt(
                Math.pow(targetX - hole[0], 2) + Math.pow(targetY - hole[1], 2)
            );
            minHoleDistance = Math.min(minHoleDistance, distanceToHole);
        }
        
        // 난이도 점수 = 흰공과의 거리 + 홀과의 거리
        // 점수가 낮을수록 더 쉬운 샷
        return distanceToTarget + minHoleDistance;
    }
    
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
				

				// 흰 공(타격구)의 좌표
                float whiteBall_x = balls[0][0];
                float whiteBall_y = balls[0][1];

                // 각 공이 이번 턴에 맞춰야 할 목적구인지 저장하는 배열
                // isTarget[1]: 1번공, isTarget[2]: 2번공, ... isTarget[5]: 8번공
                boolean[] isTarget = new boolean[6];

                // 플레이어 순서에 따라 맞춰야 할 공 결정
                if(order == 1) {
                    // 선공: 1번, 3번 공 중 더 유리한 공을 먼저 치기
                    if(balls[1][0] != -1 && balls[1][1] != -1 && 
                       balls[3][0] != -1 && balls[3][1] != -1) {  // 1번, 3번 공이 모두 남아있으면
                        // 각 공에 대해 난이도 점수 계산
                        double score1 = calculateShotDifficulty(balls[0][0], balls[0][1], 
                                                              balls[1][0], balls[1][1]);
                        double score3 = calculateShotDifficulty(balls[0][0], balls[0][1], 
                                                              balls[3][0], balls[3][1]);
                        
                        if(score1 <= score3) {  // 점수가 낮을수록 더 쉬운 샷
                            isTarget[1] = true;
                        } else {
                            isTarget[3] = true;
                        }
                    }
                    else if(balls[1][0] != -1 && balls[1][1] != -1) {  // 1번공만 남아있으면
                        isTarget[1] = true;
                    }
                    else if(balls[3][0] != -1 && balls[3][1] != -1) {  // 3번공만 남아있으면
                        isTarget[3] = true;
                    }
                    else if(balls[5][0] != -1 && balls[5][1] != -1) {  // 8번공만 남아있으면
                        isTarget[5] = true;
                    }
                } else {
                    // 후공: 2번, 4번 공 중 더 유리한 공을 먼저 치기
                    if(balls[2][0] != -1 && balls[2][1] != -1 && 
                       balls[4][0] != -1 && balls[4][1] != -1) {  // 2번, 4번 공이 모두 남아있으면
                        // 각 공에 대해 난이도 점수 계산
                        double score2 = calculateShotDifficulty(balls[0][0], balls[0][1], 
                                                              balls[2][0], balls[2][1]);
                        double score4 = calculateShotDifficulty(balls[0][0], balls[0][1], 
                                                              balls[4][0], balls[4][1]);
                        
                        if(score2 <= score4) {  // 점수가 낮을수록 더 쉬운 샷
                            isTarget[2] = true;
                        } else {
                            isTarget[4] = true;
                        }
                    }
                    else if(balls[2][0] != -1 && balls[2][1] != -1) {  // 2번공만 남아있으면
                        isTarget[2] = true;
                    }
                    else if(balls[4][0] != -1 && balls[4][1] != -1) {  // 4번공만 남아있으면
                        isTarget[4] = true;
                    }
                    else if(balls[5][0] != -1 && balls[5][1] != -1) {  // 8번공만 남아있으면
                        isTarget[5] = true;
                    }
                }

                

                // 목적구의 좌표
                float targetBall_x = -1;
                float targetBall_y = -1;

                // 순서에 맞는 다음 목적구 찾기
                int ballNumber = order;  // 선공이면 1번부터, 후공이면 2번부터 시작
                for(; ballNumber < 5; ballNumber += 2) {  // 2씩 증가하여 선공은 1,3 / 후공은 2,4 확인
                    if(isTarget[ballNumber]) {
                        targetBall_x = balls[ballNumber][0];
                        targetBall_y = balls[ballNumber][1];
                        break;
                    }
                }
                
                // 일반 공을 다 맞췄거나 없으면 8번공(5번 인덱스)을 목적구로 설정
                if(targetBall_x == -1 && targetBall_y == -1) {
                    targetBall_x = balls[5][0];
                    targetBall_y = balls[5][1];
                }

                // 목적구와 흰 공 사이의 거리와 각도 계산
                float width = Math.abs(targetBall_x - whiteBall_x);  // x축 거리
                float height = Math.abs(targetBall_y - whiteBall_y);  // y축 거리
                float dx = whiteBall_x - targetBall_x;  // x축 방향
                float dy = whiteBall_y - targetBall_y;  // y축 방향

                // 두 공 사이의 각도 계산
                double radian = height > 0? Math.atan(width / height): 0;
                angle = (float) ((180.0 / Math.PI) * radian);

                // 특수한 경우 각도 보정
                // 1. 목적구가 상하좌우 일직선상에 있는 경우
                if (whiteBall_x == targetBall_x) {  // 상하로 일직선
                    if (whiteBall_y < targetBall_y) {  // 목적구가 위쪽
                        angle = 0;
                    } else {  // 목적구가 아래쪽
                        angle = 180;
                    }
                } else if (whiteBall_y == targetBall_y) {  // 좌우로 일직선
                    if (whiteBall_x < targetBall_x) {  // 목적구가 오른쪽
                        angle = 90;
                    } else {  // 목적구가 왼쪽
                        angle = 270;
                    }
                }

                // 2. 목적구가 사분면에 위치한 경우
                // 3사분면: 좌하단
                if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
                    System.out.println("in3 " + targetBall_x + " " + targetBall_y);
                    radian = Math.atan(width / height);
                    angle = (float) (((180.0 / Math.PI) * radian) + 180);
                }
                // 4사분면: 우하단
                else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
                    System.out.println("in4 " + targetBall_x + " " + targetBall_y);
                    radian = Math.atan(height / width);
                    angle = (float) (((180.0 / Math.PI) * radian) + 90);
                }
                // 2사분면: 좌상단
                else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
                    System.out.println("in2 " + targetBall_x + " " + targetBall_y);
                    radian = Math.atan(height / width);
                    angle = (float) (((180.0 / Math.PI) * radian) + 270);
                }
                // 1사분면: 우상단
                else if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
                    System.out.println("in1 " + targetBall_x + " " + targetBall_y);
                    radian = Math.atan(height / width);
                    angle = (float) (((180.0 / Math.PI) * radian));
                }

                // 두 공 사이의 거리를 계산하여 힘 결정
                double distance = Math.sqrt((width * width) + (height * height));
                power = (float) (distance + 5);  // 거리에 따라 힘을 조절 (기본 5의 여유값 추가)

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
