package com.tarazgroup.tws.controller.application;

import com.tarazgroup.tws.dao.pub.PubSysStoreSetupRepository;
import com.tarazgroup.tws.dao.pub.PubUsersRepository;
import com.tarazgroup.tws.dao.sale.SaleSysSetupRepository;
import com.tarazgroup.tws.dao.sale.SaleVoucherDefaultRepository;
import com.tarazgroup.tws.model.application.ApplicationInfo;
import com.tarazgroup.tws.model.application.ApplicationInfoDefault;
import com.tarazgroup.tws.model.application.ApplicationInfoSale;
import com.tarazgroup.tws.model.application.Version;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubUsers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@Validated
@RestController
@RequestMapping("applicationinfo")
@Tag(name = "ApplicationInfo")
public class ApplicationInfoController {

    final private PubUsersRepository pubUsersRepository;

    final private SaleVoucherDefaultRepository saleVoucherDefaultRepository;

    final private PubSysStoreSetupRepository pubSysStoreSetupRepository;

    final private SaleSysSetupRepository saleSysSetupRepository;

    @Value("${api.version}")
    private String applicationVersion;

    @Value("${taraz.customer.company.name}")
    private String companyName;

    @Value("${taraz.customer.company.apps}")
    private String[] apps;

    public ApplicationInfoController(
            PubUsersRepository pubUsersRepository,
            SaleVoucherDefaultRepository saleVoucherDefaultRepository,
            PubSysStoreSetupRepository pubSysStoreSetupRepository,
            SaleSysSetupRepository saleSysSetupRepository) {
        this.pubUsersRepository = pubUsersRepository;
        this.saleVoucherDefaultRepository = saleVoucherDefaultRepository;
        this.pubSysStoreSetupRepository = pubSysStoreSetupRepository;
        this.saleSysSetupRepository = saleSysSetupRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve sale applicationInfo",
            description = "<code>Retrieve</code> sale <i><b>applicationInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/sale", produces = "application/json;charset=utf-8")
    public ResponseEntity<ApplicationInfoSale> applicationInfoGetSale() {
        ApplicationInfoSale applicationInfoSale = new ApplicationInfoSale();
        applicationInfoSale.voucherDefaultFromArrayList(saleVoucherDefaultRepository.saleVoucherDefaultLoggedInUser(null,true), pubSysStoreSetupRepository);
        applicationInfoSale.sysSetupFromSaleSysSetup(saleSysSetupRepository);
        return ResponseEntity.ok(applicationInfoSale);
    }

    @Operation(
            summary = "Retrieve default info of logged in user",
            description = "<code>Retrieve</code> all <i><b>default info</b></i> of logged in user",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/default", produces = "application/json;charset=utf-8")
    public ResponseEntity<ApplicationInfoDefault> getDefaultInfoOfThisUser() {
        LogLogins logLogins = pubUsersRepository.fetchUserDetail();
        PubUsers pubUsers = pubUsersRepository.pubShowUsersByID(logLogins.getPubUser().getUserID());
        ApplicationInfoDefault applicationInfoDefault = new ApplicationInfoDefault();
        applicationInfoDefault.setName(pubUsers.getFirstName());
        applicationInfoDefault.setIsAdmin(new Boolean(logLogins.getPubUser().getIsAdmin()));
        applicationInfoDefault.setFamily(pubUsers.getLastName());
        applicationInfoDefault.setPerComID(pubUsers.getUserID());
        applicationInfoDefault.setDefaultServerID(pubUsers.getDefaultServerID());
        applicationInfoDefault.setServerID(pubUsers.getServerID());
        applicationInfoDefault.setServerIDs(pubUsers.getServerIDs());
        applicationInfoDefault.setActiveYearID(logLogins.getPubUser().getActiveYearID());
        return ResponseEntity.ok(applicationInfoDefault);
    }

    @Operation(
            summary = "Retrieve application version",
            description = "<code>Retrieve</code> <i><b>application version</b></i>"
    )
    @GetMapping(value = "/version", produces = "application/json;charset=utf-8")
    public ResponseEntity<Version> applicationVersion() {
        Version version = new Version();
        version.setApiVersion(this.applicationVersion);
        return ResponseEntity.ok(version);
    }

    @Operation(
            summary = "Retrieve application info",
            description = "<code>Retrieve</code> <i><b>application info</b></i>"
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<ApplicationInfo> applicationActiveApplications() {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setCompanyName(companyName);
        applicationInfo.setApps(apps);
        return ResponseEntity.ok(applicationInfo);
    }
    //</editor-fold>
}
