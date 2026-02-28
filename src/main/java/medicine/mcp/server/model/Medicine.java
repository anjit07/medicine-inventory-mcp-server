package medicine.mcp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Medicine {

    private String id;
    private String name;
    private String genericName;
    private String brand;
    private String strength;
    private String form;
    private String batchNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    private int quantity;
    private double unitPrice;
    private String supplier;
    private String storage;
}
