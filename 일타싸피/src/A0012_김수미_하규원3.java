import java.net.*;
import java.io.*;

public class A0012_김수미_하규원3 {
	// getNextBall 메소드를 추가하여 가장 넣기 쉬운 공을 선택
	private static int getNextBall(float[][] balls, int order, boolean[] isTarget) {
	    // 각 공과 가장 가까운 홀까지의 거리를 계산
	    double minDistance = Double.MAX_VALUE;
	    int bestBall = -1;
	    
	    // 선공이면 1,3번 공 중에서, 후공이면 2,4번 공 중에서 선택
	    int startBall = order;
	    for (int i = startBall; i < 5; i += 2) {
	        if (!isTarget[i]) continue;
	        if (balls[i][0] == -1 || balls[i][1] == -1) continue;
	        
	        // 각 홀까지의 거리를 계산하여 가장 가까운 홀 찾기
	        double ballToHoleDistance = Double.MAX_VALUE;
	        for (int[] hole : HOLES) {
	            double distance = Math.sqrt(
	                Math.pow(balls[i][0] - hole[0], 2) + 
	                Math.pow(balls[i][1] - hole[1], 2)
	            );
	            ballToHoleDistance = Math.min(ballToHoleDistance, distance);
	        }
	        
	        // 흰 공에서 목적구까지의 거리 계산
	        double whiteToBallDistance = Math.sqrt(
	            Math.pow(balls[0][0] - balls[i][0], 2) + 
	            Math.pow(balls[0][1] - balls[i][1], 2)
	        );
	        
	        // 전체 거리 (흰공->목적구->홀)를 기준으로 가장 좋은 공 선택
	        double totalDistance = whiteToBallDistance + ballToHoleDistance;
	        
	        // 다른 공이 경로를 방해하는지 체크
	        boolean isBlocked = false;
	        for (int j = 1; j < 6; j++) {
	            if (j == i || balls[j][0] == -1) continue;
	            
	            // 간단한 충돌 체크 - 직선 경로 상에 다른 공이 있는지 확인
	            if (isPathBlocked(balls[0], balls[i], balls[j])) {
	                isBlocked = true;
	                totalDistance += 50; // 방해되는 공이 있다면 페널티 부여
	                break;
	            }
	        }
	        
	        if (totalDistance < minDistance) {
	            minDistance = totalDistance;
	            bestBall = i;
	        }
	    }
	    
	    // 일반 공을 모두 넣었거나 넣을 수 없는 상황이면 5번 공 선택
	    if (bestBall == -1 && isTarget[5]) {
	        return 5;
	    }
	    
	    return bestBall;
	}

	// 두 공 사이의 경로에 다른 공이 있는지 체크하는 메소드
	private static boolean isPathBlocked(float[] white, float[] target, float[] obstacle) {
	    // 직선 경로에서 장애물까지의 수직 거리가 공의 지름(5.73)보다 작으면 방해됨
	    double BALL_DIAMETER = 5.73;
	    
	    // 백터의 길이 계산
	    double dx = target[0] - white[0];
	    double dy = target[1] - white[1];
	    double length = Math.sqrt(dx * dx + dy * dy);
	    
	    // 단위 벡터 계산
	    double ux = dx / length;
	    double uy = dy / length;
	    
	    // 흰 공에서 장애물까지의 벡터
	    double ox = obstacle[0] - white[0];
	    double oy = obstacle[1] - white[1];
	    
	    // 흰 공에서 장애물까지의 벡터를 경로 방향으로 투영
	    double projection = ox * ux + oy * uy;
	    
	    // 장애물이 두 공 사이에 있는 경우에만 체크
	    if (projection > 0 && projection < length) {
	        // 경로에서 장애물까지의 수직 거리 계산
	        double distance = Math.abs(ox * uy - oy * ux);
	        return distance < BALL_DIAMETER;
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
				

				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];


				//boolean배열로 isTarget[6] 0번인덱스 안쓰고. 1,3 == -1 [5]
				//order ==2 2,4==-1 [5]

				//해당 공이 내가 쳐야되는 공인지 체크하는 배열.
				boolean[] isTarget =new boolean[6];

				//선공인지 후공인지 => order변수에 저장되어있다.
				//선공이라면 -> isTarget[1] [3] [5] 를 쳐야하는데 [5]는 제일 마지막에
				if(order ==1) {
					//1,3,5체크
					//1번공이 있다면 true로 변환
					if(balls[1][0]!=-1&&balls[1][1]!=-1) {
						isTarget[1] = true;
					}
					else if(balls[3][0]!=-1&&balls[3][1]!=-1) {
						isTarget[3] = true;
					}
					else if(balls[5][0]!=-1&&balls[5][1]!=-1) {
						isTarget[5] = true;
					}
				}else {
					if(balls[2][0]!=-1&&balls[2][1]!=-1) {
						isTarget[2] = true;
					}
					else if(balls[4][0]!=-1&&balls[4][1]!=-1) {
						isTarget[4] = true;
					}
					else if(balls[5][0]!=-1&&balls[5][1]!=-1) {
						isTarget[5] = true;
					}
				}
				//선공이면 1 3 8
				//후공이면 2 4 8
				//빗겨쳤을때 경로로
				//구멍과 목표구의 연장선을 긋고 딱공마큼 부분분 치면 구멍으로 간다
				//공뒤에 공이 있으면 안친다?

				float targetBall_x = -1;
				float targetBall_y = -1;

				int targetBallNumber = getNextBall(balls, order, isTarget);
				if (targetBallNumber != -1) {
				    targetBall_x = balls[targetBallNumber][0];
				    targetBall_y = balls[targetBallNumber][1];
				}

				int ballNumber = order; //몇번째 공을 쳐야하는지 선공이면 balls[1][]부터 후공이면 balls[2][]부터 탐색

				//공 탐색
				for(;ballNumber<5;ballNumber+=2) {
					if(isTarget[ballNumber]) {
						targetBall_x = balls[ballNumber][0];
						targetBall_y = balls[ballNumber][1];
						break;
					}
				}
				//x와 y좌표를 가져오지 못했을 경우 -> 5번공을 쳐야한다
				if(targetBall_x == -1 && targetBall_y == -1) {
					targetBall_x = balls[5][0];
					targetBall_y = balls[5][1];
				}


				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = Math.abs(targetBall_x - whiteBall_x) ;
				float height = Math.abs(targetBall_y - whiteBall_y) ;
				float dx = whiteBall_x - targetBall_x;
				float dy = whiteBall_y  - targetBall_y;

				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				//   - 1radian = 180 / PI (도)
				//   - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0? Math.atan(width / height): 0;
				angle = (float) ((180.0 / Math.PI) * radian);
				
				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x)
				{
					if (whiteBall_y < targetBall_y)
					{
						angle = 0;
					}
					else
					{
						angle = 180;
					}
				}
				else if (whiteBall_y == targetBall_y)
				{
					if (whiteBall_x < targetBall_x)
					{
						angle = 90;
					}
					else
					{
						angle = 270;
					}
				}

				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y)
				{
					System.out.println("in3 " +  targetBall_x +" "+ targetBall_y);
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian) + 180);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y)
				{
					System.out.println("in4 " +  targetBall_x +" "+ targetBall_y);
					radian = Math.atan(height / width);

					angle = (float) (((180.0 / Math.PI) * radian) + 90);
				}
				// 목적구가 2사분변에 위치 했을때 각도 계산
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
					System.out.println("in2 " +  targetBall_x +" "+ targetBall_y);
					radian = Math.atan(height / width);

					angle = (float) (((180.0 / Math.PI) * radian)+270);
				} else if ( whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
					System.out.println("in1 " +  targetBall_x +" "+ targetBall_y);
					radian = Math.atan(height / width);

					angle = (float) (((180.0 / Math.PI) * radian));
				}


				double distance = Math.sqrt((width * width) + (height * height));

				power = (float) (distance + 5);
                

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
