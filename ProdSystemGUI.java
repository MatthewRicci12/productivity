import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;



public class ProdSystemGUI {

	private JFrame frame;
	private final String PATH = "C:\\Users\\matth\\Desktop\\System\\";
	private final String COMMAND = "";
	private final Action action = new SwingAction();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdSystemGUI window = new ProdSystemGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProdSystemGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(-7, 0, 1980, 870);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel responsibTitle = new JLabel("RESPONSIBILITIES");
		responsibTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		responsibTitle.setBounds(10, 10, 276, 40);
		
		
		JLabel questTitle = new JLabel("MAIN QUESTS");
		questTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		questTitle.setBounds(672, 10, 212, 40);
		
		JLabel hangoutTitle = new JLabel("HANGOUTS");
		hangoutTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		hangoutTitle.setBounds(1249, 10, 176, 40);
		
		JLabel thoughtTitle = new JLabel("THOUGHTS");
		thoughtTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		thoughtTitle.setBounds(10, 455, 176, 40);
		
		JLabel tribeTitle = new JLabel("TRIBES");
		tribeTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		tribeTitle.setBounds(672, 455, 155, 40);
		
		JLabel projTitle = new JLabel("SIDE PROJECTS");
		projTitle.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		projTitle.setBounds(1249, 455, 230, 40);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(thoughtTitle);
		frame.getContentPane().add(tribeTitle);
		frame.getContentPane().add(projTitle);
		frame.getContentPane().add(responsibTitle);
		frame.getContentPane().add(questTitle);
		frame.getContentPane().add(hangoutTitle);
		
		JButton thoughtButton = new JButton("See Logs");
		thoughtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(Modules.THOUGHTS);
			}
		});
		thoughtButton.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		thoughtButton.setBounds(10, 495, 176, 21);
		frame.getContentPane().add(thoughtButton);
		
		JButton tribeButton = new JButton("See Logs");
		tribeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(Modules.TRIBES);
			}
		});
		tribeButton.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		tribeButton.setBounds(672, 495, 176, 21);
		frame.getContentPane().add(tribeButton);
		
		JButton hangoutButton = new JButton("See Logs");
		hangoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(Modules.HANGOUTS);
			}
		});
		hangoutButton.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		hangoutButton.setBounds(1249, 50, 176, 21);
		frame.getContentPane().add(hangoutButton);
		
		JButton questButton = new JButton("See Logs");
		questButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(Modules.QUEST);
			}
		});
		questButton.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		questButton.setBounds(672, 47, 176, 21);
		frame.getContentPane().add(questButton);
		
		JButton sideButton = new JButton("See Logs");
		sideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(Modules.SIDE);
			}
		});
		sideButton.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		sideButton.setBounds(1249, 492, 176, 21);
		frame.getContentPane().add(sideButton);
		
		makeJList();
	}
	
	private void makeJList() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String dailyTask = "";
		
		DefaultListModel<String> fileLines = new DefaultListModel<>(); 
		
		try {
			Scanner scanner = new Scanner(new File(PATH + "Responsibilities.txt"));
			while (scanner.hasNext()) {
				String nextLine = scanner.nextLine();
				switch (nextLine) {
				case "Monday:":
					if (dayOfWeek == 2) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Tuesday:":
					if (dayOfWeek == 3) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Wednesday:":
					if (dayOfWeek == 4) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Thursday:":
					if (dayOfWeek == 5) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Friday:":
					if (dayOfWeek == 6) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Saturday:":
					if (dayOfWeek == 7) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				case "Sunday:":
					if (dayOfWeek == 1) {
						fileLines.addElement(scanner.nextLine());
					} else {
						scanner.nextLine();
					}
					break;
				default:
					fileLines.addElement(nextLine + "\n");
				}
			}
			scanner.close();
			System.out.println(dayOfWeek);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		JList list = new JList(fileLines);
		list.setBounds(10, 50, 276, 395);
		frame.getContentPane().add(list);
	}
	
	private void openFile(Modules module) {
		String fileToOpen = "";
		
		switch (module) {
		case QUEST:
			fileToOpen = PATH + "Longterm.txt";
			break;
		case HANGOUTS:
			fileToOpen = PATH + "Hangouts.txt";
			break;
		case THOUGHTS:
			fileToOpen = PATH + "Thoughts.txt";
			break;
		case TRIBES:
			fileToOpen = PATH + "Tribes.txt";
			break;
		}
		
		try {
			if (module != Modules.SIDE) {
				Process process = Runtime.getRuntime().exec("notepad " + fileToOpen);
			} else {
				String[] cmd = new String[] {"cmd.exe", "/c", "start " + PATH + "SideProjs"};
				Process process = Runtime.getRuntime().exec(cmd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
