package com.cryption.app.ui.widget;

import java.io.Serializable;

import com.cryption.app.entity.DApp;

public interface OnDappClickListener extends Serializable {
    void onDappClick(DApp dapp);
}
