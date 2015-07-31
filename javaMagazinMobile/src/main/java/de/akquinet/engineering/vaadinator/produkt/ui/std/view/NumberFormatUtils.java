package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import java.text.NumberFormat;

public class NumberFormatUtils {

	public static NumberFormat createNumberFormat() {
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(1);
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		return format;
	}

}
