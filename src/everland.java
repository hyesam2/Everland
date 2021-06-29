import java.util.ArrayList;
import java.util.Scanner;

public class everland {
	public static Scanner sc = new Scanner(System.in);
	// 누적
	public static ArrayList<Integer> saveTicket = new ArrayList<Integer>();
	public static ArrayList<String> saveTicketSort = new ArrayList<String>();
	public static ArrayList<Integer> saveNumOfPeople = new ArrayList<Integer>();
	public static ArrayList<Integer> saveTotalPrice = new ArrayList<Integer>();
	public static ArrayList<Integer> saveDiscount = new ArrayList<Integer>();
	public static ArrayList<Integer> savePreferential = new ArrayList<Integer>();

	// 변수
	public static int addMore, year, month, day, age;
	public static int numOfPeople = 0;
	public static int ticket = 0;
	public static int pregnant = 0;
	public static int totalPrice = 0;
	public static int discount = 0;
	public static int disabled = 0;
	public static int sumTotal = 0;
	public static int terminate = 0;
	public static int preferential;
	static String ticketSort;

	public static void clearAll() {
		saveTicket.clear();
		saveTicketSort.clear();
		saveNumOfPeople.clear();
		saveTotalPrice.clear();
		saveDiscount.clear();
	}

	public static void ticketSort() {
		if (ticket == 60000) {
			ticketSort = "A티켓 대인/청소년";
			disabled = 36000;
			pregnant = 51000;
		} else if (ticket == 48000) {
			ticketSort = "A티켓 소인/경로";
			disabled = 28000;
		} else if (ticket == 56000) {
			ticketSort = "B티켓 대인/청소년";
			pregnant = 47000;
			disabled = 33000;
		} else if (ticket == 44000) {
			ticketSort = "B티켓 소인/경로";
			disabled = 26000;
		} else if (ticket == 50000) {
			ticketSort = "C티켓 대인/청소년";
			pregnant = 42000;
			disabled = 30000;
		} else {
			ticketSort = "C티켓 소인/경로";
			disabled = 24000;
		}
	}

	public static void preferentialSort() {
		if (discount == 1) {
			preferential = 0;
		} else if (discount == 2) {
			preferential = 50;
		} else if (discount == 3) {
			preferential = 50;
		} else if (discount == 4) {
			preferential = 20;
		} else {
			preferential = 50;
		}
	}

	public static void totalPrice() {
		if (discount == 1) {
			totalPrice = numOfPeople * ticket;
		} else if (discount == 2) {
			System.out.print("심한 정도를 입력하세요. ");
			int severity = sc.nextInt();
			if (severity >= 50) {
				if (numOfPeople >= 2) {
					totalPrice = disabled * 2 + ticket * (numOfPeople - 2);
				} else {
					totalPrice = disabled;
				}
			} else {
				totalPrice = disabled + (numOfPeople - 1) * ticket;
			}
		} else if (discount == 3) {
			if (numOfPeople >= 2) {
				totalPrice = ticket / 2 * 2 + ticket * (numOfPeople - 2);
			} else {
				totalPrice = ticket / 2;
			}
		} else if (discount == 4) {
			totalPrice = (ticket * 8 / 10) * numOfPeople;
		} else if (discount == 5) {
			if (numOfPeople >= 2) {
				totalPrice = pregnant + ticket * (numOfPeople - 1);
			} else
				totalPrice = pregnant;
		}
	}

	public static void arrayList() {
		saveTicket.add(ticket);
		saveTicketSort.add(ticketSort);
		saveNumOfPeople.add(numOfPeople);
		saveTotalPrice.add(totalPrice);
		saveDiscount.add(discount);
		savePreferential.add(preferential);
		System.out.print("추가 입력하시겠습니까? (1. 추가, 2. 종료) : ");
		addMore = sc.nextInt();
	}

	public static void inputDate() {
		while (true) {
			System.out.print("이용날짜를 입력해주세요.(yy-mm-dd) ");
			String date = sc.next();
			String yearStr = date.substring(0, 2);
			year = Integer.parseInt(yearStr);
			String monthStr = date.substring(2, 4);
			month = Integer.parseInt(monthStr);
			String dayStr = date.substring(4, 6);
			day = Integer.parseInt(dayStr);
			if (year != 21 || month < 6) {
				System.out.println("다시 입력하세요.");
			} else if (date.length() < 6) {
				System.out.println("다시 입력하세요.");
			} else {
				break;
			}

		}
	}

	public static void age() {
		System.out.print("주민번호 앞자리를 입력하세요(6자리) ");
		String IDNum = sc.next();
		String birthYearStr = IDNum.substring(0, 2);
		int birthYear = Integer.parseInt(birthYearStr);
		String birthMonthStr = IDNum.substring(2, 4);
		int birthMonth = Integer.parseInt(birthMonthStr);
		String birthDayStr = IDNum.substring(4, 6);
		int birthDay = Integer.parseInt(birthDayStr);
		System.out.print("몇 개를 입력하시겠습니까? ");
		numOfPeople = sc.nextInt();
		while (true) {
			System.out.println("우대사항을 선택하세요. \n1. 없음 \n2. 장애인 \n3. 국가유공자 \n4. 다자녀 \n5. 임산부");
			discount = sc.nextInt();
			if (discount > 5) {
				System.out.println("다시 입력하세요.");
			} else {
				break;
			}
		}

		System.out.printf("%d번을 선택하였습니다.\n", discount);

		if (birthYear >= year) {
			if (month > birthMonth || (month == birthMonth && day >= birthDay)) {
				age = year + 100 - birthYear;
			} else {
				age = year + 100 - birthYear - 1;
			}
		} else {
			if (month > birthMonth || (month == birthMonth && day >= birthDay)) {
				age = year - birthYear;
			} else
				age = year - birthYear - 1;
		}

		switch (month) {
		case 6:
			if (day <= 13 || day % 7 == 6 || day % 7 == 5) {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 50000;
				} else {
					ticket = 40000;
				}
			}
			break;
		case 7:
			if (day % 7 == 4 || day % 7 == 3 || day >= 29) {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 50000;
				} else {
					ticket = 40000;
				}
			}
			break;
		case 8:
			if (day <= 3 || day % 7 == 1 || day % 7 == 0) {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 50000;
				} else {
					ticket = 40000;
				}
			}
			break;
		case 9:
			if ((day >= 20 && day <= 22) || day % 7 == 4 || day % 7 == 5) {
				if (age >= 13 && age <= 64) {
					ticket = 60000;
				} else {
					ticket = 48000;
				}
			} else if (day <= 2) {
				if (age >= 13 && age <= 64) {
					ticket = 50000;
				} else {
					ticket = 40000;
				}
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			}
			break;
		case 10:
			if (day % 7 == 3 || day % 7 == 2) {
				if (age >= 13 && age <= 64) {
					ticket = 60000;
				} else {
					ticket = 48000;
				}
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			}
			break;
		case 11:
			if (day >= 15 && (day % 7 != 0 || day % 7 == 6)) {
				if (age >= 13 && age <= 64) {
					ticket = 50000;
				} else {
					ticket = 40000;
				}
			} else if (day == 6 || day == 7) {
				if (age >= 13 && age <= 64) {
					ticket = 60000;
				} else {
					ticket = 48000;
				}
				ticket = 60000;
			} else {
				if (age >= 13 && age <= 64) {
					ticket = 56000;
				} else {
					ticket = 44000;
				}
			}
			break;
		}
	}

	public static void printData() {
		System.out.println("================ 에버랜드 ================");
		for (int index = 0; index < saveTicketSort.size(); index++) {
			System.out.printf("%s %d원 X %d * %d번 우대 적용\n", saveTicketSort.get(index), saveTicket.get(index),
					saveNumOfPeople.get(index), saveDiscount.get(index));
			System.out.printf("-> %d번 우대 %d 퍼센트 적용 -> %d원\n", saveDiscount.get(index), savePreferential.get(index),
					saveTotalPrice.get(index));
			sumTotal += saveTotalPrice.get(index);
		}
		System.out.println("========================================");
		System.out.printf("총 금액은 %d입니다.\n", sumTotal);
	}

	public static void main(String[] args) {

		while (true) {
			clearAll();
			do {
				inputDate();
				age();
				ticketSort();
				totalPrice();
				preferentialSort();
				arrayList();
			} while (addMore == 1);
			printData();
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
