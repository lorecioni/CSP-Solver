package gui;

import problems.Sudoku;
import CSP.Variable;
import CSP.Assignment;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGui extends JFrame {
	
	private Sudoku sudoku;
	private ArrayList <JTextField> texts = new ArrayList<JTextField>();

	public SudokuGui() {
		super("Sudoku");

		sudoku = new Sudoku();
		Container c = this.getContentPane();
		 c.setLayout(new FlowLayout());
		JPanel right = new JPanel();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(9, 9));
		c.add(center);
		c.add(right);

		JButton set = new JButton();
		set.setText("Assign variables");
	
		set.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("You clicked the button");
                assignVars();
            }
        });

		right.add(set);
		
		JTextField P0 = new JTextField(null);
		JTextField P1 = new JTextField("   ");
		JTextField P2 = new JTextField("   ");

		JTextField P3 = new JTextField("   ");
		JTextField P4 = new JTextField("   ");
		JTextField P5 = new JTextField("   ");

		JTextField P6 = new JTextField("   ");
		JTextField P7 = new JTextField("   ");
		JTextField P8 = new JTextField("   ");

		JTextField P9 = new JTextField("   ");
		JTextField P10 = new JTextField("   ");
		JTextField P11 = new JTextField("   ");

		JTextField P12 = new JTextField("   ");
		JTextField P13 = new JTextField("   ");
		JTextField P14 = new JTextField("   ");
		
		JTextField P15 = new JTextField("   ");
		JTextField P16 = new JTextField("   ");
		JTextField P17 = new JTextField("   ");

		JTextField P18 = new JTextField("   ");
		JTextField P19 = new JTextField("   ");
		JTextField P20 = new JTextField("   ");
		
		JTextField P21 = new JTextField("   ");
		JTextField P22 = new JTextField("   ");
		JTextField P23 = new JTextField("   ");
		
		JTextField P24 = new JTextField("   ");
		JTextField P25 = new JTextField("   ");
		JTextField P26 = new JTextField("   ");

		JTextField P27 = new JTextField("   ");
		JTextField P28 = new JTextField("   ");
		JTextField P29 = new JTextField("   ");

		JTextField P30 = new JTextField("   ");
		JTextField P31 = new JTextField("   ");
		JTextField P32 = new JTextField("   ");

		JTextField P33 = new JTextField("   ");
		JTextField P34 = new JTextField("   ");
		JTextField P35 = new JTextField("   ");

		JTextField P36 = new JTextField("   ");
		JTextField P37 = new JTextField("   ");
		JTextField P38 = new JTextField("   ");

		JTextField P39 = new JTextField("   ");
		JTextField P40 = new JTextField("   ");
		JTextField P41 = new JTextField("   ");

		JTextField P42 = new JTextField("   ");
		JTextField P43 = new JTextField("   ");
		JTextField P44 = new JTextField("   ");

		JTextField P45 = new JTextField("   ");
		JTextField P46 = new JTextField("   ");
		JTextField P47 = new JTextField("   ");

		JTextField P48 = new JTextField("   ");
		JTextField P49 = new JTextField("   ");
		JTextField P50 = new JTextField("   ");

		JTextField P51 = new JTextField("   ");
		JTextField P52 = new JTextField("   ");
		JTextField P53 = new JTextField("   ");

		JTextField P54 = new JTextField("   ");
		JTextField P55 = new JTextField("   ");
		JTextField P56 = new JTextField("   ");

		JTextField P57 = new JTextField("   ");
		JTextField P58 = new JTextField("   ");
		JTextField P59 = new JTextField("   ");

		JTextField P60 = new JTextField("   ");
		JTextField P61 = new JTextField("   ");
		JTextField P62 = new JTextField("   ");

		JTextField P63 = new JTextField("   ");
		JTextField P64 = new JTextField("   ");
		JTextField P65 = new JTextField("   ");

		JTextField P66 = new JTextField("   ");
		JTextField P67 = new JTextField("   ");
		JTextField P68 = new JTextField("   ");

		JTextField P69 = new JTextField("   ");
		JTextField P70 = new JTextField("   ");
		JTextField P71 = new JTextField("   ");

		JTextField P72 = new JTextField("   ");
		JTextField P73 = new JTextField("   ");
		JTextField P74 = new JTextField("   ");

		JTextField P75 = new JTextField("   ");
		JTextField P76 = new JTextField("   ");
		JTextField P77 = new JTextField("   ");
		
		JTextField P78 = new JTextField("   ");
		JTextField P79 = new JTextField("   ");
		JTextField P80 = new JTextField("   ");

		
		
		texts.add(P0);
		texts.add(P1);
		texts.add(P2);
		texts.add(P3);
		texts.add(P4);
		texts.add(P5);
		texts.add(P6);
		texts.add(P7);
		texts.add(P8);
		texts.add(P9);
		texts.add(P10);
		texts.add(P11);
		texts.add(P12);
		texts.add(P13);
		texts.add(P14);
		texts.add(P15);
		texts.add(P16);
		texts.add(P17);
		texts.add(P18);
		texts.add(P19);
		texts.add(P20);
		texts.add(P21);
		texts.add(P22);
		texts.add(P23);
		texts.add(P24);
		texts.add(P25);
		texts.add(P26);
		texts.add(P27);
		texts.add(P28);
		texts.add(P29);
		texts.add(P30);
		texts.add(P31);
		texts.add(P32);
		texts.add(P33);
		texts.add(P34);
		texts.add(P35);
		texts.add(P36);
		texts.add(P37);
		texts.add(P38);
		texts.add(P39);
		texts.add(P40);
		texts.add(P41);
		texts.add(P42);
		texts.add(P43);
		texts.add(P44);
		texts.add(P45);
		texts.add(P46);
		texts.add(P47);
		texts.add(P48);
		texts.add(P49);
		texts.add(P50);
		texts.add(P51);
		texts.add(P52);
		texts.add(P53);
		texts.add(P54);
		texts.add(P55);
		texts.add(P56);
		texts.add(P57);
		texts.add(P58);
		texts.add(P59);
		texts.add(P60);
		texts.add(P61);
		texts.add(P62);
		texts.add(P63);
		texts.add(P64);
		texts.add(P65);
		texts.add(P66);
		texts.add(P67);
		texts.add(P68);
		texts.add(P69);
		texts.add(P70);
		texts.add(P71);
		texts.add(P72);
		texts.add(P73);
		texts.add(P74);
		texts.add(P75);
		texts.add(P76);
		texts.add(P77);
		texts.add(P78);
		texts.add(P79);
		texts.add(P80);
		
		center.add(P0);
		center.add(P1);
		center.add(P2);
		center.add(P3);
		center.add(P4);
		center.add(P5);
		center.add(P6);
		center.add(P7);
		center.add(P8);
		center.add(P9);
		center.add(P10);
		center.add(P11);
		center.add(P12);
		center.add(P13);
		center.add(P14);
		center.add(P15);
		center.add(P16);
		center.add(P17);
		center.add(P18);
		center.add(P19);
		center.add(P20);
		center.add(P21);
		center.add(P22);
		center.add(P23);
		center.add(P24);
		center.add(P25);
		center.add(P26);
		center.add(P27);
		center.add(P28);
		center.add(P29);
		center.add(P30);
		center.add(P31);
		center.add(P32);
		center.add(P33);
		center.add(P34);
		center.add(P35);
		center.add(P36);
		center.add(P37);
		center.add(P38);
		center.add(P39);
		center.add(P40);
		center.add(P41);
		center.add(P42);
		center.add(P43);
		center.add(P44);
		center.add(P45);
		center.add(P46);
		center.add(P47);
		center.add(P48);
		center.add(P49);
		center.add(P50);
		center.add(P51);
		center.add(P52);
		center.add(P53);
		center.add(P54);
		center.add(P55);
		center.add(P56);
		center.add(P57);
		center.add(P58);
		center.add(P59);
		center.add(P60);
		center.add(P61);
		center.add(P62);
		center.add(P63);
		center.add(P64);
		center.add(P65);
		center.add(P66);
		center.add(P67);
		center.add(P68);
		center.add(P69);
		center.add(P70);
		center.add(P71);
		center.add(P72);
		center.add(P73);
		center.add(P74);
		center.add(P75);
		center.add(P76);
		center.add(P77);
		center.add(P78);
		center.add(P79);
		center.add(P80);



		this.setSize(600, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	
	private void assignVars(){
		for (int k = 0; k < 81; k++) {
			if(texts.get(k).getText() != ""){
				sudoku.assignVar(k, texts.get(k).getText());
				System.out.println(sudoku.getAssignment());
			}
		}
		sudoku.solve();
	}

}