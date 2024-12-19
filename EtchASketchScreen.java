import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EtchASketchScreen extends JPanel {

	private int oldX, oldY, newX, newY;
	private boolean justOneKey = false; // 이동 여부

	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int RIGHT = 2;
	public final static int LEFT = 3;

	private int keyFlag;
	private final int add = 5;

	public EtchASketchScreen() {
		this.keyFlag = 0;
		this.setFocusable(true);
		this.setBackground(Color.WHITE);

		this.addKeyListener(new KeyAdapter() {

			// 키가 눌릴때는 좌우 좌표 이동 and 앞뒤 움직이기
			// 오른쪽키 셋 -> 상하
			// 왼쪽 좌우
			// 좌표가 아니라 해당 버튼으로 움직임 아예
			@Override
			public void keyPressed(KeyEvent e) {
				int whichKey = e.getKeyCode();

				switch (whichKey) {
				// 좌우
				case KeyEvent.VK_A:
					System.out.println("a");
					keyFlag = LEFT;
					changeDirection(LEFT);
					break;
				case KeyEvent.VK_D:
					System.out.println("d");
					keyFlag = RIGHT;
					changeDirection(RIGHT);
					break;
				// 상하
				case KeyEvent.VK_UP:
					System.out.println("up");
					keyFlag = UP;
					changeDirection(UP);
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("down");
					keyFlag = DOWN;
					changeDirection(DOWN);
					break;
				}
			}

			//키를 때야만 움직일 수 있게 .... 해야하는데
			@Override
			public void keyReleased(KeyEvent e) {
				int whichKey = e.getKeyCode();
				switch (whichKey) {

				case KeyEvent.VK_A:

				case KeyEvent.VK_D:

				case KeyEvent.VK_UP:

				case KeyEvent.VK_DOWN:

				}
			}

		});
	}

	public void changeDirection(int choice) {

		if(true){
			switch (choice) {
			case UP:
				if(keyFlag == UP) this.newY -= add;
				break;

			case DOWN:
				if(keyFlag == DOWN) this.newY += add;
				break;

			case RIGHT:
				if(keyFlag == RIGHT) this.newX += add;
				break;

			case LEFT:
				if(keyFlag == LEFT) this.newX -= add;
				break;
			}
		}
		repaint();
	}

	// 선 그리기
	// 기존 좌표 old 에서 누르는 곳에 따라 new 방향으로 전진
	@Override
	protected void paintComponent(Graphics g) {
		g.drawLine(oldX, oldY, newX, newY);
		//g.drawLine(oldX, oldY, 100, 100);
		this.oldX = this.newX;
		this.oldY = this.newY;
	}

	public void clear() {
		this.setBackground(Color.WHITE);
	}

}