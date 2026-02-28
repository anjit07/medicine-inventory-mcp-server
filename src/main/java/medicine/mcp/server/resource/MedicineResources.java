package medicine.mcp.server.resource;

import org.springaicommunity.mcp.annotation.McpResource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MedicineResources {

    @McpResource(
            name = "pharmacy-policy",
            description = "Pharmacy prescription and dispensing rules",
            uri = "resource://pharmacy/policy"
    )
    public String pharmacyPolicy() {

        return """
                Pharmacy Rules:

                1. Antibiotics require valid prescription.
                2. Expired medicines cannot be dispensed.
                3. Controlled drugs require ID verification.
                4. Max 30 days supply allowed.
                """;
    }

    @McpResource(
            name = "dosage-guidelines",
            description = "Standard dosage information for medicines",
            uri = "resource://medicine/dosage-guidelines"
    )
    public String dosageInfo() {

        return """
            Paracetamol: 500mg twice daily after food
            Amoxicillin: 250mg three times daily
            Crocin: 650mg twice daily
            """;
    }

    @McpResource(
            name = "pharmacy-info",
            description = "Basic pharmacy information",
            uri = "resource://pharmacy/info"
    )
    public String pharmacyInfo() {

        return "Pharmacy open from 9 AM to 9 PM.";
    }

}
