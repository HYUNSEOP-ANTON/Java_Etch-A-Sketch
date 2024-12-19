import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//프레임에 단순 붙이기 용도로만 쓰는게 날듯
public class EtchASketchMain extends JFrame {

	private JPanel screen;

	public EtchASketchMain() {
		super("Magic Screen");

		buildGUI();

		this.setBounds(100, 100, 600, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// 윈도우 관련 이벤트 처리
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				int choice = JOptionPane.showConfirmDialog(EtchASketchMain.this, "종료할까요?", "종료",
						JOptionPane.YES_NO_OPTION);

				switch (choice) {
				case JOptionPane.YES_OPTION:
					System.exit(-1);
				}
			}
		});
	}

	public void buildGUI() {
		screen = new EtchASketchScreen();
		this.add(screen);
	}

	public static void main(String[] args) {
		new EtchASketchMain();
	}

}
