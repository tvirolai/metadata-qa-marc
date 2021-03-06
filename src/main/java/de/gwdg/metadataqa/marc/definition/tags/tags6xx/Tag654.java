package de.gwdg.metadataqa.marc.definition.tags.tags6xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;
import de.gwdg.metadataqa.marc.definition.general.codelist.SubjectHeadingAndTermSourceCodes;
import de.gwdg.metadataqa.marc.definition.general.parser.LinkageParser;

/**
 * Subject Added Entry - Faceted Topical Terms
 * http://www.loc.gov/marc/bibliographic/bd654.html
 */
public class Tag654 extends DataFieldDefinition {

	private static Tag654 uniqueInstance;

	private Tag654() {
		initialize();
		postCreation();
	}

	public static Tag654 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag654();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "654";
		label = "Subject Added Entry - Faceted Topical Terms";
		mqTag = "FacetedTopicalTerms";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd654.html";

		ind1 = new Indicator("Level of subject")
			.setCodes(
				" ", "No information provided",
				"0", "No level specified",
				"1", "Primary",
				"2", "Secondary"
			)
			.setMqTag("subjectLevel");
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Focus term", "R",
			"b", "Non-focus term", "R",
			"c", "Facet/hierarchy designation", "R",
			"e", "Relator term", "R",
			"v", "Form subdivision", "R",
			"y", "Chronological subdivision", "R",
			"z", "Geographic subdivision", "R",
			"0", "Authority record control number or standard number", "R",
			"2", "Source of heading or term", "NR",
			"3", "Materials specified", "NR",
			"4", "Relationship", "R",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("4").setCodeList(RelatorCodes.getInstance());
		getSubfield("2").setCodeList(SubjectHeadingAndTermSourceCodes.getInstance());

		getSubfield("6").setContentParser(LinkageParser.getInstance());

		getSubfield("a").setMqTag("focusTerm");
		getSubfield("b").setMqTag("nonFocusTerm");
		getSubfield("c").setMqTag("facetOrHierarchy");
		getSubfield("e").setMqTag("relator");
		getSubfield("v").setBibframeTag("formGenre").setMqTag("formSubdivision");
		getSubfield("y").setBibframeTag("temporal").setMqTag("chronologicalSubdivision");
		getSubfield("z").setBibframeTag("geographic").setMqTag("geographicSubdivision");
		getSubfield("0").setMqTag("authorityRecordControlNumber");
		getSubfield("2").setMqTag("source");
		getSubfield("3").setMqTag("materialsSpecified");
		getSubfield("4").setMqTag("relationship");
		getSubfield("6").setMqTag("linkage");
		getSubfield("8").setMqTag("fieldLink");

	}
}
