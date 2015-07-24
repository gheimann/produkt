package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

import de.akquinet.engineering.vaadinator.produkt.model.WarenkorbItem;

public class WarenkorbChangeViewImplEx extends WarenkorbChangeViewImpl implements WarenkorbChangeViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WarenkorbChangeViewImplEx() {
		super();
	}

	protected Table produktTabelle = new Table();

	@Override
	public void initializeUi() {
		super.initializeUi();
		sectionBasisdaten.setCaption(null);
		cancel.setCaption(obtainBundle().getString("close"));
		save.setVisible(false);
		produktTabelle.setSelectable(true);
		produktTabelle.addStyleName("styleid-WarenkorbChangeViewImplEx-produktTabelle");
		produktTabelle.setCellStyleGenerator(new com.vaadin.ui.Table.CellStyleGenerator() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getStyle(com.vaadin.ui.Table source, Object itemId, Object propertyId) {
				return "cell-" + propertyId;
			}
		});
		produktTabelle.setWidth("100%");
		layout.addComponent(produktTabelle);
	}

	@Override
	public void setProduktListe(List<WarenkorbItem> produktListe) {
		List<String> visibleCols = new ArrayList<String>();
		visibleCols.add("bezeichnung");
		visibleCols.add("preis");
		produktTabelle.setContainerDataSource(new BeanItemContainer<WarenkorbItem>(WarenkorbItem.class, produktListe), visibleCols);
		produktTabelle.setColumnHeader("bezeichnung", obtainBundle().getString("entity.Produkt.property.bezeichnung"));
		produktTabelle.setColumnHeader("preis", obtainBundle().getString("entity.Produkt.property.preis"));
	}

}
