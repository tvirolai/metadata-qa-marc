package de.gwdg.metadataqa.marc.definition.controlsubfields.tag007;

import de.gwdg.metadataqa.marc.Utils;
import de.gwdg.metadataqa.marc.definition.ControlSubfield;

/**
 * Level of compression
 * https://www.loc.gov/marc/bibliographic/bd007c.html
 */
public class Tag007electro12 extends ControlSubfield {
	private static Tag007electro12 uniqueInstance;

	private Tag007electro12() {
		initialize();
		extractValidCodes();
	}

	public static Tag007electro12 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag007electro12();
		return uniqueInstance;
	}

	private void initialize() {
		label = "Level of compression";
		id = "tag007electro12";
		mqTag = "levelOfCompression";
		positionStart = 12;
		positionEnd = 13;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd007c.html";
		codes = Utils.generateCodes(
			"a", "Uncompressed",
			"b", "Lossless",
			"d", "Lossy",
			"m", "Mixed",
			"u", "Unknown",
			"|", "No attempt to code"
		);
		defaultCode = "|";
	}
}