/**
 *
 */

function mockAVc() {

    var vcData = [
        {"name": "vc1", description: "desc1", sourcePath: "source/path"}
    ];
    return vcData;


}

function mockAVc2() {

    var vcData = [
        {"name": "vc2", description: "desc1", sourcePath: "source/path"}
    ];
    return vcData;


}


describe("Tests of virtual collections", function () {

    var virtualCollectionsService, $http, $httpBackend, $log;
    beforeEach(module('virtualCollectionsModule'));
    beforeEach(inject(function (_virtualCollectionsService_, _$http_, _$httpBackend_, _$log_) {
        virtualCollectionsService = _virtualCollectionsService_;
        $http = _$http_;
        $log = _$log_;
        $httpBackend = _$httpBackend_;
    }));

    it("list virtual collections should return a list of colls", function () {
        var actual;

        var irodsAccountVal = irodsAccount("host", 1247, "zone", "user", "password", "", "resc");
        var vc = mockAVc();
        $httpBackend.whenGET('virtualCollection').respond(vc);
        virtualCollectionsService.listUserVirtualCollections().then(function (d) {
            actual = d;
        });

        $httpBackend.flush();
        console.log("actual is:" + actual);

        expect($log.info.logs).toContain(['doing get of virtual collections']);

        expect(actual.data).toEqual(vc);
        expect(actual.status).toEqual(200);
    });

    it("list virtual collections should return an exception from http", function () {
        var actual;

        var irodsAccountVal = irodsAccount("host", 1247, "zone", "user", "password", "", "resc");
        $httpBackend.whenGET('virtualCollection').respond('500',"error");
        virtualCollectionsService.listUserVirtualCollections(irodsAccountVal).then(function (d) {
            actual = d;
        });

        $httpBackend.flush();
        console.log("actual is:" + actual);

      // expect($log.info.logs).toContain(['doing get of virtual collections']);

     //   expect(actual.status).toEqual(500);
    });


});