import java.util.ArrayList;

public class EverlandArray {
	public ArrayList<Integer> saveTicket = new ArrayList<Integer>();
	public ArrayList<String> saveTicketSort = new ArrayList<String>();
	public ArrayList<Integer> saveNumOfPeople = new ArrayList<Integer>();
	public ArrayList<Integer> saveTotalPrice = new ArrayList<Integer>();
	public ArrayList<Integer> saveDiscount = new ArrayList<Integer>();
	public ArrayList<Integer> savePreferential = new ArrayList<Integer>();
	public int sumTotal = 0;

	public void clearAll() {
		saveTicket.clear();
		saveTicketSort.clear();
		saveNumOfPeople.clear();
		saveTotalPrice.clear();
		saveDiscount.clear();
	}

	public void arrayList(int ticket, String ticketSort, int numOfPeople, int totalPrice, int discount,
			int preferential) {
		saveTicket.add(ticket);
		saveTicketSort.add(ticketSort);
		saveNumOfPeople.add(numOfPeople);
		saveTotalPrice.add(totalPrice);
		saveDiscount.add(discount);
		savePreferential.add(preferential);
	}

	public void printData() {
		System.out.println("================ 에버랜드 ================");
		for (int index = 0; index < saveTicketSort.size(); index++) {
			System.out.printf("%s %d원 X %d * %d번 우대 적용\n", saveTicketSort.get(index), saveTicket.get(index),
					saveNumOfPeople.get(index), saveDiscount.get(index));
			System.out.printf("(%d 퍼센트 할인) => 총 %d원\n", savePreferential.get(index), saveTotalPrice.get(index));
			sumTotal += saveTotalPrice.get(index);
		}
		System.out.println("========================================");
		System.out.printf("총 금액은 %d입니다.\n", sumTotal);
	}
}
