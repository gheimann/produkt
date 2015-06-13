package de.akquinet.engineering.vaadinator.produkt.model;

import de.akquinet.engineering.vaadinator.annotations.DisplayEnum;

public enum Anreden {
	HERR, FRAU, @DisplayEnum(captionText = "Fräulein")
	FROLLEIN
}
