/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security.strategy;

/**
 *
 * @author desarrollo
 */
public class FactoryStrategy {

    private static FactoryStrategy _instance;
    private FactoryStrategy(){

    }

    public static FactoryStrategy getInstance() {
        if(_instance == null)
            _instance=new FactoryStrategy();
        return _instance;
    }

    public StrategyCreateUser getStrategy(){
        return new CreateUserFirst();
    }
}
