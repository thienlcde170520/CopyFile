
package Repository;

import DataAccess.CopyDao;


public class CopyRepository implements ICopyRepository{
   
    @Override
    public void readFileConfig() {
        CopyDao.Instance().readFileConfig();
    }
    
}

