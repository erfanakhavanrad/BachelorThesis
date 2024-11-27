package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "AccShowTafsiliTypeToAccount",
        procedureName = "AccShowTafsiliTypeToAccount",
        resultClasses = {AccTafsiliTypeToAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
@Table(name = "AccTafsiliTypeToAccount")
//@IdClass(AccTafsiliTypeToAccountID.class)
public class AccTafsiliTypeToAccount extends TParams implements Serializable {

    /*@Transient
    @Parameter(hidden = true)
    private UUID _id = UUID.randomUUID();*/

/*
    @EmbeddedId
    private AccTafsiliTypeToAccountID accTafsiliTypeToAccountID = new AccTafsiliTypeToAccountID();
*/



    /*  @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private BigDecimal Id;

        public BigDecimal getId() {
            return Id;
        }

        public void setId(BigDecimal id) {
            Id = id;
        }*/
/*
    @MapsId("accountID")
*/
    @Column(name = "AccountID")
    private BigDecimal accountID;

//    @MapsId("tafsiliTypeID")
    @Column(name = "TafsiliTypeID")
    private BigDecimal TafsiliTypeID;


    @Column(name = "RelatedLevel", columnDefinition = "decimal")
    @Parameter
    @Id
    private BigDecimal relatedLevel;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    @Transient
    private BigDecimal serverID;


    /*public UUID get_id() {
            return _id;
        }

        public void set_id(UUID _id) {
            this._id = _id;
        }*/

/*    public AccTafsiliTypeToAccountID getAccTafsiliTypeToAccountID() {
        return accTafsiliTypeToAccountID;
    }

    public void setAccTafsiliTypeToAccountID(AccTafsiliTypeToAccountID accTafsiliTypeToAccountID) {
        this.accTafsiliTypeToAccountID = accTafsiliTypeToAccountID;
    }*/

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getTafsiliTypeID() {
        return TafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        TafsiliTypeID = tafsiliTypeID;
    }

    public BigDecimal getRelatedLevel() {
        return relatedLevel;
    }

    public void setRelatedLevel(BigDecimal relatedLevel) {
        this.relatedLevel = relatedLevel;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
