package de.akquinet.engineering.vaadinator.produkt;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vaadin.annotations.Theme;

import de.akquinet.engineering.vaadinator.produkt.dao.ProduktDaoPlain;
import de.akquinet.engineering.vaadinator.produkt.dao.WarenkorbDaoPlain;
import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktServicePlain;
import de.akquinet.engineering.vaadinator.produkt.service.WarenkorbService;
import de.akquinet.engineering.vaadinator.produkt.service.WarenkorbServicePlain;
import de.akquinet.engineering.vaadinator.produkt.ui.std.presenter.PresenterFactoryEx;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.VaadinViewFactoryEx;

/**
 * Abgeleitete Klasse, um einen URL-Parameter für "Kunde" auszulesen u nd eine
 * beschränkte Ansicht anzuzeigen (dient in unserer Demo als Ersatz für ein
 * Berechtigungs-System)
 * 
 * @author srothbucher
 * 
 */
@Theme("touchkitprodukt")
public class JavaMagazinMobileUIEx extends JavaMagazinMobileUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JavaMagazinMobileUIEx() {
		super();
	}

	PresenterFactoryEx presenterFactory = null;

	@Override
	protected PresenterFactoryEx obtainPresenterFactory(String contextPath) {
		if (presenterFactory == null) {
			// Entity-Manager NUR Thread-Safe, wenn er injected wird wie hier
			ProduktService produktService;
			WarenkorbService warenkorbService;
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaMagazinMobile");
			ProduktDaoPlain produktDaoPlain = new ProduktDaoPlain(entityManagerFactory);
			produktService = new ProduktServicePlain(entityManagerFactory, produktDaoPlain);
			WarenkorbDaoPlain warenkorbDaoPlain = new WarenkorbDaoPlain(entityManagerFactory);
			warenkorbService = new WarenkorbServicePlain(entityManagerFactory, warenkorbDaoPlain);
			presenterFactory = new PresenterFactoryEx(new HashMap<String, Object>(), new VaadinViewFactoryEx(),
					produktService, warenkorbService, new Warenkorb());
			// System.out.println(getPage().getLocation().getQuery());
			boolean adminMode = getPage().getLocation().getQuery() != null
					&& getPage().getLocation().getQuery().contains("adminMode");
			if (adminMode) {
				System.err.println("Admin-Modus!");
			}
			presenterFactory.setAdminMode(adminMode);
		}
		return presenterFactory;
	}

}
