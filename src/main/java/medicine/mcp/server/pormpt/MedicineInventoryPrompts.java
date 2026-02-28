package medicine.mcp.server.pormpt;

import medicine.mcp.server.tools.MedicineTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpPrompt;
import org.springframework.stereotype.Component;

@Component
public class MedicineInventoryPrompts {

    Logger logger = LoggerFactory.getLogger(MedicineInventoryPrompts.class);

    @McpPrompt(
            name = "inventory-summary",
            description = "Get complete inventory summary"
    )
    public String inventorySummary() {

        logger.info("PROMPT: inventory-summary ");
        return """
                Generate a medical inventory summary.

                Include:

                - Total number of medicines
                - Total stock quantity
                - Low stock medicines (quantity < 200)
                - Expiring medicines (within 6 months)
                - Cold storage medicines

                Mark alerts clearly.
                """;
    }

    @McpPrompt(
            name = "low-stock-alert",
            description = "Find low stock medicines"
    )
    public String lowStockAlert() {

        logger.info("PROMPT: low-stock-alert ");
        return """
                Find medicines where quantity is less than given number by user ,if not then 200.

                Return:

                - Medicine name
                - Quantity
                - Supplier
                - Batch number

                Mark them as LOW STOCK ALERT.
                """;
    }

    @McpPrompt(
            name = "expiry-alert",
            description = "Find expiring medicines"
    )
    public String expiryAlert() {

        logger.info("PROMPT: expiryAlert");
        return """
                Identify medicines that will expire within next 6 months.

                Include:

                - Medicine name
                - Batch number
                - Expiry date
                - Quantity

                Mark them as EXPIRY ALERT.
                """;
    }


    @McpPrompt(
            name = "check-medicine-stock",
            description = "Check stock of specific medicine"
    )
    public String checkMedicineStock() {

        logger.info("PROMPT: checkMedicineStock");
        return """
                Check stock level of requested medicine.

                Return:

                - Medicine name
                - Quantity
                - Batch number
                - Expiry date
                - Storage type
                - Supplier
                """;
    }

    @McpPrompt(
            name = "cold-storage-medicines",
            description = "List cold storage medicines"
    )
    public String coldStorageMedicines() {

        logger.info("PROMPT: coldStorageMedicines");
        return """
                List all medicines requiring cold storage.

                Include:

                - Medicine name
                - Quantity
                - Expiry date
                - Batch number

                Mark as COLD STORAGE.
                """;
    }

    @McpPrompt(
            name = "restock-recommendation",
            description = "Recommend medicines for restocking"
    )
    public String restockRecommendation() {

        logger.info("PROMPT: restockRecommendation");
        return """
                Recommend medicines that need restocking.

                Condition:

                quantity less than 150

                Include:

                - Medicine name
                - Quantity
                - Supplier

                Mark as RESTOCK REQUIRED.
                """;
    }
    @McpPrompt(
            name = "list-all-medicines",
            description = "List all medicines"
    )
    public String listAllMedicines() {

        logger.info("PROMPT: list-all-medicines");
        return """
                List all available medicines.

                Include:

                - Medicine name
                - Quantity
                - Batch number
                - Expiry date
                - Supplier
                - Storage
                """;
    }

    @McpPrompt(
            name = "supplier-medicines",
            description = "Find medicines by supplier"
    )
    public String supplierMedicines(String supplierName) {

        logger.info("PROMPT: supplier-medicines");
        return """
            Find medicines supplied by %s.
            
            Response format:
                Medicine Name:
               supplier Name
            Include full details.
            """.formatted(supplierName);

    }

    @McpPrompt(
            name = "medicine-prescription-info",
            description = "Get prescription details and available quantity for given medicine"
    )
    public String getMedicinePrescriptionInfo(String medicineName) {

        return """
                You are a pharmacy assistant.

                The user will provide a medicine name: %s

                Your tasks:

                1. Find the medicine in inventory using available tools
                3. Return available quantity

                Response format:

                Medicine Name:
                Available Quantity:
                prescription:
           
                If medicine is not available, clearly say NOT AVAILABLE.
                """.formatted(medicineName);

    }

}
