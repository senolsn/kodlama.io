package kodlama.io.devs;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.concretes.LanguageManager;
import kodlama.io.devs.dataAccess.concretes.InMemoryLanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Language language1 = new Language(10, "C#");
		Language language2 = new Language(11,"Assembly");
		Language language3 = new Language(12,"");
		
		LanguageService languageService = new LanguageManager(new InMemoryLanguageRepository());
		
		languageService.add(language1);
		languageService.delete(language1);
		for (Language lang : languageService.getAll()) {
			
			System.out.println(lang.getName());
		}
//		languageService.add(language2);
//		languageService.add(language3);
//		
//		languageService.update(language1, "C++");
//		System.out.println(language1.getName());
//		
//		System.out.println(languageService.getbyId(1).getName());
//		System.out.println(languageService.getAll());

	}

}
