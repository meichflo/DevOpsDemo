/* angular/path imports */
import {Component, Type} from "@angular/core";
import {PathAppComponent} from "path-framework/app/path-framework/path-app.component";
import {PathService} from "path-framework/app/path-framework/service/path.service";
import {TranslationService} from "path-framework/app/path-framework/service/translation.service";
import {CustomPageElement} from "path-framework/app/path-framework/page/element/custom/custom-container.component";

/* model imports */
import * as handler from "./gui-model/form/handlers";
import * as beans from "./gui-model/generated/forms";
import {GuiModel} from "./gui-model/guimodel";
import {ExampleTranslationService} from "./example-translation-service";
import {ExampleComponent} from "./custom/example.component";

@Component({
    selector: "path-application",
    templateUrl: "./../../node_modules/path-framework/app/path-framework/path-app.component.html",
    providers: [PathService, {provide: TranslationService, useClass: ExampleTranslationService}]
})
export class ExampleAppComponent extends PathAppComponent {

    private _appConfig = new GuiModel();

    constructor(pathService: PathService, translationService: TranslationService) {
        super(pathService, translationService);
    }

    protected getFrontendVersion(): string {
        return "0.0.1";
    }

    protected getStartPage(): string {
        return "mainmenu";
    }

    protected getOwnUserForm(): string {
        return "UserForm";
    }

    public getGuiModel() {
        if (this._appConfig != null) {
            return this._appConfig.guiModel;
        }
        return null;
    }

    public getBackendUrl() {
        if (window.location.hostname.indexOf("localhost") !== -1 && window.location.port === "4200") {
            return "http://localhost:8080/services";
        } else if (window.location.hostname.indexOf("gitpod.io") !== -1) {
            let gitpodUrl = window.location.href;
            gitpodUrl = gitpodUrl.replace("https://4200", "https://4567");
            return gitpodUrl + "services";
        }
        let url: string = window.location.href;
        url = url.replace("/#", "");
        if (url.endsWith("/")) {
            return url + "services";
        }
        return url + "/services";
    }

    protected getBeans() {
        return beans;
    }

    protected getHandlers() {
        return handler;
    }

    protected getCustomComponentClass(componentType: string): Type<CustomPageElement> {
        if (componentType === "ExampleComponent") {
            console.log("Path Example: " + componentType);
            return <any>ExampleComponent;
        }
        return super.getCustomComponentClass(componentType);
    }

    showTimeAndDate() {
        const now = new Date();
        alert(`Current date and time: ${now}`);
    }

}

