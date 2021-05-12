package ECommerceProject.core.verifications;

import java.util.Random;
import java.util.Scanner;

import ECommerceProject.entities.concretes.User;

public class SmsVerificationManager implements VerificationService {

	@Override
	public boolean verificate(User user) {
		Scanner scanner = new Scanner(System.in);
		char isDecision = 'h';
		System.out.println(
				user.getFirstName() + " adlý kiþinin telefonuna gelen doðrulama kodunu girmek istiyor musunuz? (E/H)");
		isDecision = scanner.next().charAt(0);

		if (isDecision == 'e' || isDecision == 'E') {
			Random random = new Random();
			int randomInteger, ýAmNotARobot, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesabýnýz doðrulamak için telefona gelen 6 haneli sayýyý giriniz:\n--> " + randomInteger);
				ýAmNotARobot = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"Bir çok yanlýþ denemenizden kaynaklý hesabýnýzý þuanda doðrulayamýyoruz.\nLütfen daha sonra tekrar deneyiniz.");
					scanner.close();
					return false;
				}
			} while (!(ýAmNotARobot == randomInteger) && count < 4);
			System.out.println("Tebrikler hesabýnýz doðrulandý.");
			user.setVerified(true);
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}
}
