package de.akquinet.engineering.vaadinator.produkt;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.akquinet.engineering.vaadinator.produkt.dao.ProduktDaoPlain;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktServicePlain;
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
public class javaMagazinMobileUIEx extends javaMagazinMobileUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public javaMagazinMobileUIEx() {
		super();
	}

	PresenterFactoryEx presenterFactory = null;

	@Override
	protected PresenterFactoryEx obtainPresenterFactory(String contextPath) {
		if (presenterFactory == null) {
			// Entity-Manager NUR Thread-Safe, wenn er injected wird wie hier
			ProduktService produktService;
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javaMagazinMobile");
			ProduktDaoPlain produktDaoPlain = new ProduktDaoPlain(entityManagerFactory);
			produktService = new ProduktServicePlain(entityManagerFactory, produktDaoPlain);
			presenterFactory = new PresenterFactoryEx(new HashMap<String, Object>(), new VaadinViewFactoryEx(),
					produktService);
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
