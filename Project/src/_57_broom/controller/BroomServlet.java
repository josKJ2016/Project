package _57_broom.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _11_room.model.RoomVO;
import _13_roomtype.model.RoomTypeVO;
import _57_broom.model.BroomService;

@WebServlet(urlPatterns={"/broom/broomeServlet"})
public class BroomServlet extends HttpServlet{

	private BroomService bService = new BroomService(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("/broom/broomeServlet:action:"+action);
		
		if ("listroom".equals(action)) {
			String roomId = req.getParameter("roomId");
			List<RoomVO> roomlist = new LinkedList<RoomVO>();
			Map<Integer, String> roomTypeMap = new HashMap<Integer, String>();
			System.out.println(roomId.trim());
			// 判斷選一間還是選很多間
			if (roomId.matches("\\d{1,}")) {
				RoomVO roomVO= bService.getOneRoom(Integer.parseInt(roomId)); 
				if (roomVO!= null)	roomlist.add(roomVO);
			} else {
				roomlist = bService.listroom();
				resp.setCharacterEncoding("UTF-8");
				// 去除空白
				for (RoomVO vo : roomlist) {
					vo.setRoom_type(vo.getRoom_type().trim());
					vo.setrContext(vo.getrContext().trim());
				}
			}

			//回傳房間資料
			if (roomlist.size() != 0)
				req.setAttribute("rooms", roomlist);
			
			//回傳房型資料
			for(RoomTypeVO rtVo:bService.getAllRoom_Type()){
				roomTypeMap.put(rtVo.getRoomType_id(), rtVo.getRoom_type().trim());
			}
			if (roomTypeMap.size() != 0)
				req.setAttribute("roomTypeMap", roomTypeMap);
			
			req.getRequestDispatcher("/02_Server/_57_Room/Room.jsp").forward(req, resp);

		} else if ("subOne".equals(action)) {
			// 接收
			String tempId = req.getParameter("id");
			String tempRStatus = req.getParameter("rStatus");
			String rContext = req.getParameter("rContext");
			String room_type = req.getParameter("room_type");
			System.out.println("/broom/broomeServlet:room_type "+room_type);
			// 驗證
			// 轉換
			Integer id = Integer.parseInt(tempId);
			boolean rStatus = Boolean.valueOf(tempRStatus);
			// 呼叫
			bService.updateOneRoomStatus(id, rStatus, rContext, room_type);
			// 不送回
		} else if ("AllSubmit".equals(action)) {
			// 接收&驗證&轉換
			String tempI = req.getParameter("number");
			Integer i = Integer.parseInt(tempI);
			for (int l = 0; l < i; l++) {
				String tempRoom_id = req.getParameter(String.format("room_id%d", l));
				String tempRStatus = req.getParameter(String.format("rStatus%d", l));
				Integer id = Integer.parseInt(tempRoom_id);
				boolean rStatus = Boolean.valueOf(tempRStatus);
				String rContext = req.getParameter(String.format("rContext%d", l));
				String room_type = req.getParameter(String.format("room_type%d", l));
				bService.updateOneRoomStatus(id, rStatus, rContext,room_type);
			}

			// 呼叫
			// 不送回
			//req.getParameter("room_id0");
		}  else if ("addOneRoom".equals(action)) {
			String tempRoomId = req.getParameter("roomId");
			int room_id = Integer.parseInt(tempRoomId);
			bService.addOneRoom(room_id);
		}
	}
}
