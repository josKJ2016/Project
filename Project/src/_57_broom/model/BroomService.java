package _57_broom.model;

import java.util.LinkedList;
import java.util.List;

import _11_room.model.RoomDAO;
import _11_room.model.RoomDAO_interface;
import _11_room.model.RoomVO;
import _13_roomtype.model.RoomTypeDAO;
import _13_roomtype.model.RoomTypeDAO_interface;
import _13_roomtype.model.RoomTypeVO;

public class BroomService {
	private RoomDAO_interface roomDAO = new RoomDAO();
	private RoomTypeDAO_interface roomTypeDAO = new RoomTypeDAO();
	
    public List<RoomVO> listroom() {
	List<RoomVO> rooms = roomDAO.getAll();
	return rooms;
    }
	public RoomVO getOneRoom(int room_id) {
		return roomDAO.findByPrimaryKey(room_id);
	}
	public void updateOneRoomStatus(Integer id, boolean rStatus, String rContext
		,String room_type) {
		RoomVO rVo = roomDAO.findByPrimaryKey(id);
		rVo.setrStatus(rStatus);
		rVo.setrContext(rContext);
		rVo.setRoom_type(room_type);
		roomDAO.update(rVo);
	}

	public List<RoomTypeVO> getAllRoom_Type(){
		return roomTypeDAO.getAll();
	}
	
	public int addOneRoom(Integer room_id) {
		RoomVO rVo = roomDAO.findByPrimaryKey(room_id);
		if (rVo == null) {
			RoomTypeVO roomType = new RoomTypeVO();
			roomType.setRoomType_id(1);
			rVo.setRoomType(roomType);
			rVo.setRoom_id(room_id);
			rVo.setrStatus(true);
			rVo.setRoom_type(new RoomTypeDAO().findByPrimaryKey(1).getRoom_type());
			rVo.setrContext("");
			roomDAO.insert(rVo);
			return 1;
		} else {
			// 添加錯誤訊息
		}
		return 0;
	}

	public void addListRooms() {

	}

	public void updateOneRoom() {

	}

	public void updateAllRoom() {

	}

	public List<Integer> getAllRoomid() {
		List<RoomVO> list = roomDAO.getAll();
		List<Integer> roomids = new LinkedList<Integer>();
		for (RoomVO rVo : list) {
			roomids.add(rVo.getRoom_id());
		}
		return roomids;
	}

	// 懶得打,先列min和max
	public String getAllUnusedRoomid() {
		List<Integer> list = getAllRoomid();
		int min = list.get(0);
		int max = list.get(list.size() - 1);
		return null;
	}
}
