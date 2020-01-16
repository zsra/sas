import { NgModule } from '@angular/core';
import { MatToolbarModule, MatCardModule, MatMenuModule } from '@angular/material';

@NgModule({
    exports: [
        MatToolbarModule,
        MatCardModule,
        MatMenuModule
    ]
})
export class AngularMaterialModule {
}