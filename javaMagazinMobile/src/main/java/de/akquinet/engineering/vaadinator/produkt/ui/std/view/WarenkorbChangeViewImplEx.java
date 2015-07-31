package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.Converter.ConversionException;
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

	private final NumberFormat format = NumberFormatUtils.createNumberFormat();

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
		produktTabelle.setContainerDataSource(new BeanItemContainer<WarenkorbItem>(WarenkorbItem.class, produktListe),
				visibleCols);
		produktTabelle.setConverter("preis", new Converter<String, Double>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Double convertToModel(String value, Class<? extends Double> targetType, Locale locale)
					throws ConversionException {
				try {
					return value == null ? null : format.parse(value).doubleValue();
				} catch (ParseException e) {
					throw new ConversionException(e);
				}
			}

			@Override
			public String convertToPresentation(Double value, Class<? extends String> targetType, Locale locale)
					throws ConversionException {
				return value == null ? null : format.format(value);
			}

			@Override
			public Class<Double> getModelType() {
				return Double.class;
			}

			@Override
			public Class<String> getPresentationType() {
				return String.class;
			}
		});
		produktTabelle.setColumnHeader("bezeichnung", obtainBundle().getString("entity.Produkt.property.bezeichnung"));
		produktTabelle.setColumnHeader("preis", obtainBundle().getString("entity.Produkt.property.preis"));
	}

	@Override
	public double getBruttoSumme() {
		try {
			return format.parse(bruttoSumme.getValue()).doubleValue();
		} catch (ParseException e) {
			throw new ConversionException(e);
		}
	}

	@Override
	public void setBruttoSumme(double bruttoSumme) {
		this.bruttoSumme.setValue(format.format(bruttoSumme));
	}

	@Override
	public double getNettoSumme() {
		try {
			return format.parse(nettoSumme.getValue()).doubleValue();
		} catch (ParseException e) {
			throw new ConversionException(e);
		}
	}

	@Override
	public void setNettoSumme(double nettoSumme) {
		this.nettoSumme.setValue(format.format(nettoSumme));
	}

	@Override
	public double getMwStSumme() {
		try {
			return format.parse(mwStSumme.getValue()).doubleValue();
		} catch (ParseException e) {
			throw new ConversionException(e);
		}
	}

	@Override
	public void setMwStSumme(double mwStSumme) {
		this.mwStSumme.setValue(format.format(mwStSumme));
	}

}
