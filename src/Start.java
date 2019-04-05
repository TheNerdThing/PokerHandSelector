/**
 * 
 */

/**
 * @author Gregory Evevsky
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.printComponets();
		int count =0; 
		while(true) {
			count ++;
			
			if(count % 100000 == 0) {
			System.out.println("_________________________");
//			System.out.println(main.getBounds());
			System.out.println(main.printComponets());
			
			}
			
		}

	}

}
