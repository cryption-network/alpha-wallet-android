package com.cryption.app.router;

import android.content.Context;
import android.content.Intent;

import com.cryption.app.C;
import com.cryption.app.ui.RedeemSignatureDisplayActivity;
import com.cryption.app.ui.widget.entity.TicketRangeParcel;
import com.cryption.app.entity.tokens.Token;
import com.cryption.app.entity.Wallet;

/**
 * Created by James on 25/01/2018.
 */

public class RedeemSignatureDisplayRouter {
    public void open(Context context, Wallet wallet, Token token, TicketRangeParcel range) {
        Intent intent = new Intent(context, RedeemSignatureDisplayActivity.class);
        intent.putExtra(C.Key.WALLET, wallet);
        intent.putExtra(C.Key.TICKET, token);
        intent.putExtra(C.Key.TICKET_RANGE, range);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}