package de.gwdg.metadataqa.marc.definition.controlsubfields.tag007;

import de.gwdg.metadataqa.marc.Utils;
import de.gwdg.metadataqa.marc.definition.ControlSubfield;

/**
 * Color
 * https://www.loc.gov/marc/bibliographic/bd007h.html
 */
public class Tag007microform09 extends ControlSubfield {
	private static Tag007microform09 uniqueInstance;

	private Tag007microform09() {
		initialize();
		extractValidCodes();
	}

	public static Tag007microform09 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag007microform09();
		return uniqueInstance;
	}

	private void initialize() {
		label = "Color";
		id = "tag007microform09";
		mqTag = "color";
		positionStart = 9;
		positionEnd = 10;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd007h.html";
		codes = Utils.generateCodes(
			"b", "Black-and-white",
			"c", "Multicolored",
			"m", "Mixed",
			"u", "Unknown",
			"z", "Other",
			"|", "No attempt to code"
		);
	}
}