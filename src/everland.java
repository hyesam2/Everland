import java.util.ArrayList;
import java.util.Scanner;

public class everland {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int addMore, year, month, day, age;
		int numOfPeople = 0;
		int ticket = 0;
		int pregnant = 0;
		int totalPrice = 0;
		int discount = 0;
		int disabled = 0;
		int sumTotal = 0;
		int terminate = 0;
		String ticketSort;

		// ����
		ArrayList<Integer> saveTicket = new ArrayList<Integer>();
		ArrayList<String> saveTicketSort = new ArrayList<String>();
		ArrayList<Integer> saveNumOfPeople = new ArrayList<Integer>();
		ArrayList<Integer> saveTotalPrice = new ArrayList<Integer>();
		ArrayList<Integer> saveDiscount = new ArrayList<Integer>();
		while (true) {
			saveTicket.clear();
			saveTicketSort.clear();
			saveNumOfPeople.clear();
			saveTotalPrice.clear();
			saveDiscount.clear();

			do {
				// �̿볯¥ String���� int�� ����
				while (true) {
					System.out.print("�̿볯¥�� �Է����ּ���.(yy-mm-dd) ");
					String date = sc.next();
					String yearStr = date.substring(0, 2);
					year = Integer.parseInt(yearStr);
					String monthStr = date.substring(2, 4);
					month = Integer.parseInt(monthStr);
					String dayStr = date.substring(4, 6);
					day = Integer.parseInt(dayStr);
					if (year != 21 || month < 6) {
						System.out.println("�ٽ� �Է��ϼ���.");
					} else if (date.length() < 6) {
						System.out.println("�ٽ� �Է��ϼ���.");
					} else {
						break;
					}

				}

				// ���� Ȯ��
				System.out.print("�ֹι�ȣ ���ڸ��� �Է��ϼ���(6�ڸ�) ");
				String IDNum = sc.next();
				String birthYearStr = IDNum.substring(0, 2);
				int birthYear = Integer.parseInt(birthYearStr);
				String birthMonthStr = IDNum.substring(2, 4);
				int birthMonth = Integer.parseInt(birthMonthStr);
				String birthDayStr = IDNum.substring(4, 6);
				int birthDay = Integer.parseInt(birthDayStr);
				System.out.print("�� ���� �Է��Ͻðڽ��ϱ�? ");
				numOfPeople = sc.nextInt();
				while (true) {
					System.out.println("�������� �����ϼ���. \n1. ���� \n2. ����� \n3. ���������� \n4. ���ڳ� \n5. �ӻ��");
					discount = sc.nextInt();
					if (discount > 5) {
						System.out.println("�ٽ� �Է��ϼ���.");
					} else {
						break;
					}
				}

				System.out.printf("%d���� �����Ͽ����ϴ�.\n", discount);

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

				if (ticket == 60000) {
					ticketSort = "AƼ�� ����/û�ҳ�";
					disabled = 36000;
					pregnant = 51000;
				} else if (ticket == 48000) {
					ticketSort = "AƼ�� ����/���";
					disabled = 28000;
				} else if (ticket == 56000) {
					ticketSort = "BƼ�� ����/û�ҳ�";
					pregnant = 47000;
					disabled = 33000;
				} else if (ticket == 44000) {
					ticketSort = "BƼ�� ����/���";
					disabled = 26000;
				} else if (ticket == 50000) {
					ticketSort = "CƼ�� ����/û�ҳ�";
					pregnant = 42000;
					disabled = 30000;
				} else {
					ticketSort = "CƼ�� ����/���";
					disabled = 24000;
				}
				// totalPrice ���

				if (discount == 1) {
					totalPrice = numOfPeople * ticket;
				} else if (discount == 2) {
					System.out.print("���� ������ �Է��ϼ���. ");
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
				saveTicket.add(ticket);
				saveTicketSort.add(ticketSort);
				saveNumOfPeople.add(numOfPeople);
				saveTotalPrice.add(totalPrice);
				saveDiscount.add(discount);
				System.out.print("�߰� �Է��Ͻðڽ��ϱ�? (1. �߰�, 2. ����) : ");
				addMore = sc.nextInt();
			} while (addMore == 1);
			System.out.println("================ �������� ================");
			for (int index = 0; index < saveTicketSort.size(); index++) {
				System.out.printf("%s X %d %d * %d�� ��� ����\n", saveTicketSort.get(index), saveNumOfPeople.get(index),
						saveTotalPrice.get(index), saveDiscount.get(index));
				sumTotal += saveTotalPrice.get(index);
			}
			System.out.println("========================================");
			System.out.printf("�� �ݾ��� %d�Դϴ�.\n", sumTotal);

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
