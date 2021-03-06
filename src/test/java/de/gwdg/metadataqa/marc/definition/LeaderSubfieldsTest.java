package de.gwdg.metadataqa.marc.definition;

import de.gwdg.metadataqa.marc.Code;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaderSubfieldsTest extends Control00XSubfieldsTest {

	@Test
	public void testSubfields() {
		List<ControlSubfield> subfields = LeaderSubfields.getSubfields();
		testControlSubfields(subfields);
		testGetControlField(subfields);
	}

	private void testGetControlField(List<ControlSubfield> subfields) {
		for (ControlSubfield subfield : subfields) {
			assertTrue(
				String.format("%s: %s  should contain leader", subfield.getId(), subfield.getDescriptionUrl()),
				subfield.getDescriptionUrl().contains("leader")
			);
			assertEquals("leader", subfield.getId().substring(0, 6));
			assertEquals(subfield.getId(), "Leader", subfield.getControlField());
		}
	}

	protected boolean isException(ControlSubfield subfield, Code code) {
		return (
			   (subfield.getId().equals("tag006map16") && code.getCode().equals("||"))
			|| (subfield.getId().equals("tag006visual01") && code.getCode().equals("001-999"))
		);
	}

}
