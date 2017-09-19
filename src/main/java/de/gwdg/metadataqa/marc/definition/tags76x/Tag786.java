package de.gwdg.metadataqa.marc.definition.tags76x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;

/**
 * Data Source Entry
 * http://www.loc.gov/marc/bibliographic/bd786.html
 */
public class Tag786 extends DataFieldDefinition {

	private static Tag786 uniqueInstance;

	private Tag786() {
		initialize();
	}

	public static Tag786 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag786();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "786";
		label = "Data Source Entry";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Note controller").setCodes(
			"0", "Display note",
			"1", "Do not display note"
		);
		ind2 = new Indicator("Display constant controller").setCodes(
			" ", "Data source",
			"8", "No display constant generated"
		);
		setSubfieldsWithCardinality(
			"a", "Main entry heading", "NR",
			"b", "Edition", "NR",
			"c", "Qualifying information", "NR",
			"d", "Place, publisher, and date of publication", "NR",
			"g", "Related parts", "R",
			"h", "Physical description", "NR",
			"i", "Relationship information", "R",
			"j", "Period of content", "NR",
			"k", "Series data for related item", "R",
			"m", "Material-specific details", "NR",
			"n", "Note", "R",
			"o", "Other item identifier", "R",
			"p", "Abbreviated title", "NR",
			"r", "Report number", "R",
			"s", "Uniform title", "NR",
			"t", "Title", "NR",
			"u", "Standard Technical Report Number", "NR",
			"v", "Source Contribution", "NR",
			"w", "Record control number", "R",
			"x", "International Standard Serial Number", "NR",
			"y", "CODEN designation", "NR",
			"z", "International Standard Book Number", "R",
			"4", "Relationship", "R",
			"6", "Linkage", "NR",
			"7", "Control subfield", "NR",
			"8", "Field link and sequence number", "R"
		);
		getSubfield("7").setCodes(
			"0", "Type of main entry heading",
			"1", "Form of name",
			"2", "Type of record",
			"3", "Bibliographic level"
		);
		getSubfield("4").setCodeList(RelatorCodes.getInstance());
	}
}