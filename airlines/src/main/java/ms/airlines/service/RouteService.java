package ms.airlines.service;

import lombok.extern.slf4j.Slf4j;
import ms.airlines.dto.RouteDto;
import ms.airlines.dto.converter.RouteDtoConverter;
import ms.airlines.dto.request.CreateRouteRequest;
import ms.airlines.dto.request.UpdateRouteRequest;
import ms.airlines.exception.RouteNotFoundException;
import ms.airlines.helper.Generator;
import ms.airlines.helper.messages.BusinessLogMessage;
import ms.airlines.helper.messages.BusinessMessage;
import ms.airlines.model.Route;
import ms.airlines.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RouteService {
    private final RouteRepository routeRepository;
    private final RouteDtoConverter converter;

    public RouteService(RouteRepository routeRepository,
                        RouteDtoConverter converter) {
        this.routeRepository = routeRepository;
        this.converter = converter;
    }

    public void createRoute(CreateRouteRequest request) {
        Route route = new Route();

        route.setAirport(request.getAirport());
        route.setDestination(request.getDestination());
        route.setRouteCode(Generator.generateRouteCode());

        routeRepository.save(route);
        log.info(BusinessLogMessage.Route.ROUTE_CREATED);

    }

    public void updateRoute(final String id, UpdateRouteRequest request) {
        Route route = findRouteByRouteId(id);

        route.setAirport(request.getAirport());
        route.setDestination(request.getDestination());

        routeRepository.save(route);
        log.info(BusinessLogMessage.Route.ROUTE_UPDATED + id);
    }

    public void updateAirport(final String id, final String airport) {
        Route route = findRouteByRouteId(id);

        route.setAirport(airport);

        routeRepository.save(route);
        log.info(BusinessLogMessage.Route.ROUTE_UPDATED + id);
    }

    public void updateDestination(final String id, final String destination) {
        Route route = findRouteByRouteId(id);

        route.setDestination(destination);

        routeRepository.save(route);
        log.info(BusinessLogMessage.Route.ROUTE_UPDATED + id);
    }

    public void deleteRoute(final String id) {
        routeRepository.delete(findRouteByRouteId(id));
        log.info(BusinessLogMessage.Route.ROUTE_DELETED + id);
    }

    public RouteDto findRouteById(final String id) {
        Route route = findRouteByRouteId(id);

        log.info(BusinessLogMessage.Route.ROUTE_FOUND + id);
        return converter.convert(route);
    }

    public List<RouteDto> findAllRoutes() {
        List<Route> routes = routeRepository.findAll();

        if (routes.isEmpty()) {
            log.error(BusinessLogMessage.Route.ROUTE_LIST_EMPTY);
            throw new RouteNotFoundException(BusinessMessage.Route.ROUTE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Route.ROUTE_LISTED);
        return converter.convert(routes);
    }

    protected Route findRouteByRouteId(final String id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Route.ROUTE_NOT_FOUND + id);
                    return new RouteNotFoundException(BusinessMessage.Route.ROUTE_NOT_FOUND);
                });
    }

}
