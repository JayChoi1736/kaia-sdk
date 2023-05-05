package org.klaytn;

import opensdk.sdk.apis.*;
import org.web3j.protocol.http.HttpService;

/**
 * @author Tungnd
 * @since 28/03/2023 3:20 PM
 */
public class OpenSDK {

    private String url;

    public EthApi eth;

    public KlayApi klay;

    public NetApi net;

    public TxpoolApi txpool;

    public PersonalApi personal;

    public DebugApi debug;

    public AdminApi admin;

    public MainbridgeApi mainbridge;

    public SubbridgeApi subbridge;

    public GovernanceApi governance;

    public OpenSDK(String url) {
        eth = new EthApi(new HttpService(url));
        klay = new KlayApi(new HttpService(url));
        net = new NetApi(new HttpService(url));
        txpool = new TxpoolApi(new HttpService(url));
        personal = new PersonalApi(new HttpService(url));
        admin = new AdminApi(new HttpService(url));
        mainbridge = new MainbridgeApi(new HttpService(url));
        subbridge = new SubbridgeApi(new HttpService(url));
        governance = new GovernanceApi(new HttpService(url));

        debug = new DebugApi(new CustomHttpService(url));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
