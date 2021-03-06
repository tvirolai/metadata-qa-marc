package de.gwdg.metadataqa.marc.definition.controlsubfields.leader;

import de.gwdg.metadataqa.marc.Utils;
import de.gwdg.metadataqa.marc.definition.ControlSubfield;

/**
 * Bibliographic level
 * https://www.loc.gov/marc/bibliographic/bdleader.html
 */
public class Leader07 extends ControlSubfield {
	private static Leader07 uniqueInstance;

	private Leader07() {
		initialize();
		extractValidCodes();
	}

	public static Leader07 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Leader07();
		return uniqueInstance;
	}

	private void initialize() {
		label = "Bibliographic level";
		id = "leader07";
		mqTag = "bibliographicLevel";
		positionStart = 7;
		positionEnd = 8;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bdleader.html";
		codes = Utils.generateCodes(
			"a", "Monographic component part",
			"b", "Serial component part",
			"c", "Collection",
			"d", "Subunit",
			"i", "Integrating resource",
			"m", "Monograph/Item",
			"s", "Serial"
		);

		historicalCodes = Utils.generateCodes(
			"p", "Pamphlet [OBSOLETE, 1988] [CAN/MARC only]"
		);
	}
}