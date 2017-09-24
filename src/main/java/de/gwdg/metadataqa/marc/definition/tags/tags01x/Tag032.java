package de.gwdg.metadataqa.marc.definition.tags.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Musical Incipits Information
 * http://www.loc.gov/marc/bibliographic/bd031.html
 */
public class Tag032 extends DataFieldDefinition {

	private static Tag032 uniqueInstance;

	private Tag032() {
		initialize();
	}

	public static Tag032 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag032();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "032";
		label = "Postal Registration Number";
		bibframeTag = "PostalRegistration";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator();
		ind2 = new Indicator();
		setSubfieldsWithCardinality(
			"a", "Postal registration number", "NR",
			"b", "Source agency assigning number", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);
		getSubfield("a").setBibframeTag("rdf:value");
	}
}