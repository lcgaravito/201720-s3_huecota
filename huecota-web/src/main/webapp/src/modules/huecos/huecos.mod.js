(function (ng) {
    var mod = ng.module("huecosModule", ['ui.router']);
    mod.constant("huecosContext", "api/huecos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/huecos/';
            $urlRouterProvider.otherwise("/huecosList");

            $stateProvider.state('huecos', {
                url: '/huecos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'huecos.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('huecosList', {
                url: '/list',
                parent: 'huecos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'huecos.list.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('huecosDetail', {
                url: '/{huecosId:int}/detail',
                parent: 'huecos',
                param: {
                    huecoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'huecos.detail.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('huecosCreate', {
                url: '/create',
                parent: 'huecos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/huecos.new.html',
                        controller: 'huecosNewCtrl'
                    }
                }
            }).state('huecosUpdate', {
                url: '/update/{huecosId:int}',
                parent: 'huecos',
                param: {
                    huecoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/huecos.new.html',
                        controller: 'huecosUpdateCtrl'
                    }
                }
            }).state('huecosDelete', {
                url: '/delete/{huecosId:int}',
                parent: 'huecos',
                param: {
                    huecoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/huecos.delete.html',
                        controller: 'huecosDeleteCtrl'
                    }
                }
            }).state('huecosDireccion', {
                url: '/direcciones',
                parent: 'huecos',
                views: {
                    'listView': {
                        templateUrl: 'src/modules/direcciones/direcciones.list.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
