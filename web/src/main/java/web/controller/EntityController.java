package web.controller;


//
//@RestController
//public class EntityController {
//    @Autowired
//    private EntityService entityService;
//
//    @Autowired
//    private EntityConverter entityConverter;
//
//    private static final Logger log = LogManager.getLogger(EntityController.class);
//
//    @RequestMapping(value = "/entities", method = RequestMethod.GET)
//    public EntitiesDto getAll() {
//        log.trace("EntityController::getAll()");
//        List<Entity> entities = entityService.findAll();
//
//        return new EntitiesDto(entityConverter.convertModelsToDtos(entities));
//    }
//
////    @RequestMapping(value = "/entities", method = RequestMethod.POST)
////    public Map<String, EntityDto> createEntity(@RequestBody final Map<String, EntityDto> map) {
////        log.trace("EntityController::createEntity()");
////        EntityDto entityDto = map.get("entity");
////        Entity entity = entityService.createEntity(entityDto.getName());
////        log.trace("created: " + entity.getName());
////        Map<String, EntityDto> res = new HashMap<>();
////        res.put("entity", entityConverter.convertModelToDto(entity));
////        return res;
////    }
//}
