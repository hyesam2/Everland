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
				System.out.print("추가 입력하시겠습니까? (1. 추가, 2. 종료) : ");
				addMore = sc.nextInt();
			} while (addMore == 1);
			everArray.printData();
			System.out.print("구매를 끝내시겠습니까? (0 누르면 종료) ");
			terminate = sc.nextInt();
			if (terminate != 0) {
			} else {
				System.out.println("구매가 종료되었습니다.");
				break;
			}
		}
		sc.close();
	}

}