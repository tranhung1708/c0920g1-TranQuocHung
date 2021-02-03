package vn.codegym.Model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    private String contractDetailId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id" ,  nullable = false)
    private Contract contract;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "attach_service_id" ,  nullable = false)
    private AttachService attachService;

    public ContractDetail() {
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contract_detail_id) {
        this.contractDetailId = contract_detail_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
