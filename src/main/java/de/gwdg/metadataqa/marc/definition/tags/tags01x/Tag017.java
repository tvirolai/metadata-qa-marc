package de.gwdg.metadataqa.marc.definition.tags.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Copyright or Legal Deposit Number
 * http://www.loc.gov/marc/bibliographic/bd017.html
 */
public class Tag017 extends DataFieldDefinition {

	private static Tag017 uniqueInstance;

	private Tag017() {
		initialize();
	}

	public static Tag017 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag017();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "017";
		label = "Copyright or Legal Deposit Number";
		bibframeTag = "CopyrightNumber";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator();
		ind2 = new Indicator("Display constant controller").setCodes(
			" ", "Copyright or legal deposit number",
			"8", "No display constant generated"
		).setMqTag("displayConstant");
		setSubfieldsWithCardinality(
			"a", "Copyright or legal deposit number", "R",
			"b", "Assigning agency", "NR",
			"d", "Date", "NR",
			"i", "Display text", "NR",
			"z", "Canceled/invalid copyright or legal deposit number", "R",
			"2", "Source", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);
		// getSubfield("2").setCodeList(OrganizationCodes.getInstance());
		getSubfield("a").setBibframeTag("rdf:value");
		getSubfield("b").setBibframeTag("source");
		getSubfield("d").setBibframeTag("date");
		getSubfield("i").setBibframeTag("note");
	}
}