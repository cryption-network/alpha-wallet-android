package com.cryption.app.entity.tokenscript;

import com.cryption.token.entity.XMLDsigDescriptor;

public class TokenScriptFileData
{
    public String hash;
    public XMLDsigDescriptor sigDescriptor;

    public TokenScriptFileData()
    {
        hash = null;
        sigDescriptor = null;
    }
}
