package lmj.outfood.modules.monitor.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.monitor.domain.Server;
import lmj.outfood.modules.monitor.service.dto.ServerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zhang houying
* @date 2019-11-03
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerMapper extends BaseMapper<ServerDTO, Server> {

}
