import java.util.LinkedList;


public interface IFloorPanelQueue 
{
  void putFloorRequest(int currentFloornumber, Direction direction);
  
  void dispatchFloorRequest(int currentFloornumber, Direction direction);
  
  void setMetaContoller(IMetaController metaController);
}
