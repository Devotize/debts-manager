//
//  iOSApp.swift
//  iosApp
//
//  Created by Denis Sychev on 24.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ZStack {
                Color.white.ignoresSafeArea(.all) // status bar color
                ContentView()
            }.preferredColorScheme(.light)
        }
    }
}
