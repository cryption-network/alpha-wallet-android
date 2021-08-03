  //<![CDATA[
  class Token {

    constructor(tokenInstance) {
      this.props = tokenInstance;
    }

    render() {
      let message = "Stake Amount to CNTStaker.";
      return `
          <div class="ui container">
            <div id="inputBox">
                <bold><h3>Stake to CNTStaker</h3></bold>
                <span><input id="stakeAmountUserInput" type="number"></span>
            </div>
          </div>
  `;
    }
  }

  web3.tokens.dataChanged = (oldTokens, updatedTokens, tokenCardId) => {
    const currentTokenInstance = web3.tokens.data.currentInstance;
    document.getElementById(tokenCardId).innerHTML = new Token(currentTokenInstance).render();
  };

  //]]>
