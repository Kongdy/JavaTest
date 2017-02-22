package test;

import java.util.List;

/**
 * 积分商城商品分页信息
 * @author wangk
 */
public class JfMallItemPageDto {
	public int total;
	public boolean hasMore;
	public int limit;
	public List<JfMallItemDto> records;
	
}
