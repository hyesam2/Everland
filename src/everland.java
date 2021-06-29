import java.util.Scanner;

public class Everland {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EverlandProcess everProcess = new EverlandProcess();
		EverlandArray everArray = new EverlandArray();
		int addMore;
		int terminate;
		while (true) {
			everArray.clearAll();
			do {
				everProcess.inputDate();
				everProcess.age();
				everProcess.ticketSort();
				everProcess.totalPrice();
				everProcess.preferentialSort();
				everArray.arrayList(everProcess.ticket, everProcess.ticketSort, everProcess.numOfPeople,
						everProcess.totalPrice, everProcess.discount, everProcess.preferential);
				System.out.print("�߰� �Է��Ͻðڽ��ϱ�? (1. �߰�, 2. ����) : ");
				addMore = sc.nextInt();
			} while (addMore == 1);
			everArray.printData();
			System.out.print("���Ÿ� �����ðڽ��ϱ�? (0 ������ ����) ");
			terminate = sc.nextInt();
			if (terminate != 0) {
			} else {
				System.out.println("���Ű� ����Ǿ����ϴ�.");
				break;
			}
		}
		sc.close();
	}

}